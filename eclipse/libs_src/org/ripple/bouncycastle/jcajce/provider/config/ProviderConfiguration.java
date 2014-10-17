package org.ripple.bouncycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;

import org.ripple.bouncycastle.jce.spec.ECParameterSpec;

public interface ProviderConfiguration {
	ECParameterSpec getEcImplicitlyCa();

	DHParameterSpec getDHDefaultParameters(int keySize);
}
