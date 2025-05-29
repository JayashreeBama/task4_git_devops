import java.security.*;
import javax.crypto.*;
import java.util.*;
public class DES{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
try{

KeyGenerator key=KeyGenerator.getInstance("DES");
SecretKey mykey=key.generateKey();
Cipher des;
des=Cipher.getInstance("DES/ECB/PKCS5Padding");
System.out.println("Enter the message u need to perform encryption & decryption : ");
String m=sc.nextLine();
byte[] msg=m.getBytes();
System.out.println("Message in byte format : "+msg);
System.out.println("Message in text format : "+ new String(msg));
des.init(Cipher.ENCRYPT_MODE,mykey);
byte[] encrypt=des.doFinal(msg);
System.out.println("Encrypted Message : "+encrypt);
des.init(Cipher.DECRYPT_MODE,mykey);
byte[] decrypt=des.doFinal(encrypt);
System.out.println("Decrypted Message : "+new String(decrypt));

}catch(Exception e){System.out.println(e);}
}
}