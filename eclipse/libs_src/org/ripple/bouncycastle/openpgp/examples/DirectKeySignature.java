package org.ripple.bouncycastle.openpgp.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Iterator;

import org.ripple.bouncycastle.bcpg.ArmoredOutputStream;
import org.ripple.bouncycastle.bcpg.BCPGOutputStream;
import org.ripple.bouncycastle.bcpg.sig.NotationData;
import org.ripple.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ripple.bouncycastle.openpgp.PGPPrivateKey;
import org.ripple.bouncycastle.openpgp.PGPPublicKey;
import org.ripple.bouncycastle.openpgp.PGPPublicKeyRing;
import org.ripple.bouncycastle.openpgp.PGPSecretKey;
import org.ripple.bouncycastle.openpgp.PGPSecretKeyRing;
import org.ripple.bouncycastle.openpgp.PGPSignature;
import org.ripple.bouncycastle.openpgp.PGPSignatureGenerator;
import org.ripple.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.ripple.bouncycastle.openpgp.PGPSignatureSubpacketVector;
import org.ripple.bouncycastle.openpgp.PGPUtil;
import org.ripple.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.ripple.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.ripple.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

/**
 * A simple utility class that directly signs a public key and writes the signed
 * key to "SignedKey.asc" in the current working directory.
 * <p>
 * To sign a key: DirectKeySignature secretKeyFile secretKeyPass
 * publicKeyFile(key to be signed) NotationName NotationValue.<br/>
 * </p>
 * <p>
 * To display a NotationData packet from a publicKey previously signed:
 * DirectKeySignature signedPublicKeyFile.<br/>
 * </p>
 * <p>
 * <b>Note</b>: this example will silently overwrite files, nor does it pay any
 * attention to the specification of "_CONSOLE" in the filename. It also expects
 * that a single pass phrase will have been used.
 * </p>
 */
public class DirectKeySignature {
	public static void main(String[] args) throws Exception {
		Security.addProvider(new BouncyCastleProvider());

		if (args.length == 1) {
			PGPPublicKeyRing ring = new PGPPublicKeyRing(
					PGPUtil.getDecoderStream(new FileInputStream(args[0])),
					new JcaKeyFingerprintCalculator());
			PGPPublicKey key = ring.getPublicKey();

			// iterate through all direct key signautures and look for
			// NotationData subpackets
			Iterator iter = key.getSignaturesOfType(PGPSignature.DIRECT_KEY);
			while (iter.hasNext()) {
				PGPSignature sig = (PGPSignature) iter.next();

				System.out.println("Signature date is: "
						+ sig.getHashedSubPackets().getSignatureCreationTime());

				NotationData[] data = sig.getHashedSubPackets()
						.getNotationDataOccurences();// .getSubpacket(SignatureSubpacketTags.NOTATION_DATA);

				for (int i = 0; i < data.length; i++) {
					System.out.println("Found Notaion named '"
							+ data[i].getNotationName() + "' with content '"
							+ data[i].getNotationValue() + "'.");
				}
			}
		} else if (args.length == 5) {
			// gather command line arguments
			PGPSecretKeyRing secRing = new PGPSecretKeyRing(
					PGPUtil.getDecoderStream(new FileInputStream(args[0])),
					new JcaKeyFingerprintCalculator());
			String secretKeyPass = args[1];
			PGPPublicKeyRing ring = new PGPPublicKeyRing(
					PGPUtil.getDecoderStream(new FileInputStream(args[2])),
					new JcaKeyFingerprintCalculator());
			String notationName = args[3];
			String notationValue = args[4];

			// create the signed keyRing
			PGPPublicKeyRing sRing = new PGPPublicKeyRing(
					new ByteArrayInputStream(signPublicKey(
							secRing.getSecretKey(), secretKeyPass,
							ring.getPublicKey(), notationName, notationValue,
							true)), new JcaKeyFingerprintCalculator());
			ring = sRing;

			// write the created keyRing to file
			ArmoredOutputStream out = new ArmoredOutputStream(
					new FileOutputStream("SignedKey.asc"));
			sRing.encode(out);
			out.flush();
			out.close();
		} else {
			System.err
					.println("usage: DirectKeySignature secretKeyFile secretKeyPass publicKeyFile(key to be signed) NotationName NotationValue");
			System.err.println("or: DirectKeySignature signedPublicKeyFile");

		}
	}

	private static byte[] signPublicKey(PGPSecretKey secretKey,
			String secretKeyPass, PGPPublicKey keyToBeSigned,
			String notationName, String notationValue, boolean armor)
			throws Exception {
		OutputStream out = new ByteArrayOutputStream();

		if (armor) {
			out = new ArmoredOutputStream(out);
		}

		PGPPrivateKey pgpPrivKey = secretKey
				.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder()
						.setProvider("BC").build(secretKeyPass.toCharArray()));

		PGPSignatureGenerator sGen = new PGPSignatureGenerator(
				new JcaPGPContentSignerBuilder(secretKey.getPublicKey()
						.getAlgorithm(), PGPUtil.SHA1).setProvider("BC"));

		sGen.init(PGPSignature.DIRECT_KEY, pgpPrivKey);

		BCPGOutputStream bOut = new BCPGOutputStream(out);

		sGen.generateOnePassVersion(false).encode(bOut);

		PGPSignatureSubpacketGenerator spGen = new PGPSignatureSubpacketGenerator();

		boolean isHumanReadable = true;

		spGen.setNotationData(true, isHumanReadable, notationName,
				notationValue);

		PGPSignatureSubpacketVector packetVector = spGen.generate();
		sGen.setHashedSubpackets(packetVector);

		bOut.flush();

		if (armor) {
			out.close();
		}

		return PGPPublicKey.addCertification(keyToBeSigned, sGen.generate())
				.getEncoded();
	}
}
