package com.pruebas.keystore;

import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.ExternalDigest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.MakeSignature.CryptoStandard;
import com.itextpdf.text.pdf.security.PrivateKeySignature;
import com.itextpdf.text.pdf.security.TSAClientBouncyCastle;

public class Firmar {

	private static final Logger logger = LoggerFactory
			.getLogger(Firmar.class);
	
	//DATOS DEL TSA DE PRUEBA
	private final String  TSA_URL ="http://ca.signfiles.com/TSAServer.aspx";
	private final String  TSA_USUARIO ="";
	private final String  TSA_PASSWORD ="";
	
	public Firmar(){
		
	}

	public void firmarPdf(String origen, String destino) {

		try {
			KeyStore keyStore = KeyStore.getInstance("JKS");
			String pass = "123456"; //PASSWORD DE LA KEYSTORE
			java.io.FileInputStream file = new java.io.FileInputStream(
					"C:\\keystore.jks"); //EL ARCHIVO QUE GENERAMOS TIENE QUE ESTAR EN EL DISCO C
			keyStore.load(file, pass.toCharArray());
			PrivateKey pk = (PrivateKey) keyStore.getKey("mtorre4580",
					pass.toCharArray());//USUARIO Y PASSWORD DE LA KEYSTORE
			Certificate[] chain = keyStore.getCertificateChain("mtorre4580"); //OBTENGO EL CERTIFICADO
			PdfReader reader = new PdfReader(origen);
			FileOutputStream os = new FileOutputStream(destino);
			PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');
			PdfSignatureAppearance appearance = stamper
					.getSignatureAppearance();
			appearance.setReason("Firmar documento con itext mtorre4580");
			appearance.setLocation("Argentina");
			appearance.setVisibleSignature(new Rectangle(72, 732, 144, 780), 1,
					"signature");
			ExternalSignature es = new PrivateKeySignature(pk, "SHA1", "BC");
			TSAClientBouncyCastle tsc = new TSAClientBouncyCastle(TSA_URL,
					TSA_USUARIO, TSA_PASSWORD); //SE AGREGA TSA
			ExternalDigest digest = new BouncyCastleDigest();
			MakeSignature.signDetached(appearance, digest, es, chain, null,
					null, tsc, 0, CryptoStandard.CMS);
		} catch (Exception e) {
			logger.error("Error al firmar el pdf");
		}
	}
}
