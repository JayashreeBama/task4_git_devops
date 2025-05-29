import java.util.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;


public class AES{

private static SecretKeySpec secretkey;
private static byte[] key;

public static void setkey(String mykey)
{
MessageDigest sha=null;
try{
key=mykey.getBytes("UTF-8");
sha=MessageDigest.getInstance("SHA-1");
key=sha.digest(key);
key=Arrays.copyOf(key,16);
secretkey= new SecretKeySpec(key,"AES");
}catch(Exception e){System.out.println(e);}
}

public static String encrypt(String msg,String secret)
{
try{
setkey(secret);
Cipher aes;
aes=Cipher.getInstance("AES/ECB/PKCS5Padding");
aes.init(Cipher.ENCRYPT_MODE,secretkey);
return Base64.getEncoder().encodeToString(aes.doFinal(msg.getBytes("UTF-8")));
}catch(Exception e){System.out.println(e);}
return null;
}

public static String decrypt(String msg,String secret)
{
try{
setkey(secret);
Cipher aes;
aes=Cipher.getInstance("AES/ECB/PKCS5Padding");
aes.init(Cipher.DECRYPT_MODE,secretkey);
return new String(aes.doFinal(Base64.getDecoder().decode(msg)));
}catch(Exception e){System.out.println(e);}
return null;
}

public static void main(String args[]){
Scanner sc = new Scanner(System.in);
final String secretkey="annaUniversity";
System.out.println("Enter the msg to encrypt & decrypt ");
String msg=sc.nextLine();
String ep=AES.encrypt(msg,secretkey);
String dp=AES.decrypt(ep,secretkey);
System.out.println("Encryption "+ep);
System.out.println("Decryption "+dp);
}
}

