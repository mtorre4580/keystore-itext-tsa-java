# Digital Signature

Example itext (http://itextpdf.com/) using a keystore created by the Java JDK, also adds TSA

How to create a keystore:

Open the cmd console: stand in the java directory

in my case: C: \ Program Files \ Java \ jdk1.6.0_21 \ bin

Run the command to create the keystore:

keytool -genkeypair RSA alias mtorre4580 -keyalg -keystore keystore.jks

List command to display keystores:

keytool -list -keystore keystore.jks

TSA for test used: http://ca.signfiles.com/TSAServer.aspx
