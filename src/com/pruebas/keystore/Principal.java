package com.pruebas.keystore;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Principal {

	public static void main(String args[]) {
		Security.addProvider(new BouncyCastleProvider());
		Firmar firma = new Firmar();
		firma.firmarPdf("C:\\TEST.pdf", "C:\\TEST_FIRMADO.pdf");
	}
}
