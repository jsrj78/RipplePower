package org.ripple.bouncycastle.crypto.tls;

public abstract class ServerOnlyTlsAuthentication implements TlsAuthentication {
	public final TlsCredentials getClientCredentials(
			CertificateRequest certificateRequest) {
		return null;
	}
}
