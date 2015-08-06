# Firma-Digital
Ejemplo de firma digital con itext (http://itextpdf.com/), utilizando una keystore creada por la jdk de java, se agrega tambien TSA

Como crear una keystore:

Abrir la consola cmd : pararse en el directorio de java

en mi caso: C:\Program Files\Java\jdk1.6.0_21\bin

Ejecutar el comando para crear la keystore:

keytool -genkeypair -alias mtorre4580 -keyalg RSA -keystore keystore.jks

Comando para mostrar lista de keystores:

keytool -list -keystore keystore.jks 

Para el TSA se usa de test : http://ca.signfiles.com/TSAServer.aspx

--------

Digital Signature example itext (http://itextpdf.com/) using a keystore created by the Java JDK, also adds TSA

How to create a keystore:

Open the cmd console: stand in the java directory

in my case: C: \ Program Files \ Java \ jdk1.6.0_21 \ bin

Run the command to create the keystore:

keytool -genkeypair RSA alias mtorre4580 -keyalg -keystore keystore.jks

List command to display keystores:

keytool -list -keystore keystore.jks

TSA for test used: http://ca.signfiles.com/TSAServer.aspx
