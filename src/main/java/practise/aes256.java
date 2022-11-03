package practise;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.Charset;
import java.security.SecureRandom;

public class aes256 {
    final static String charsetName = "UTF-8";
    static final String ALGORITHM = "AES";
    static Charset charset = Charset.forName(charsetName);


    public static SecretKey generateKey(){
        KeyGenerator secretGenerate = null;
        try{
            secretGenerate = KeyGenerator.getInstance(ALGORITHM);
        }catch (Exception e){
            System.out.println("error");
        }

        //Random每天生成864000个key
        SecureRandom secureRandom = new SecureRandom();
        secretGenerate.init(secureRandom);
        SecretKey secretKey = secretGenerate.generateKey();
        return secretKey;
    }


    public static byte[] encrypt(String content, SecretKey secretKey) throws Exception{
        return aes(content.getBytes(charset), Cipher.ENCRYPT_MODE, secretKey);
    }
    public static String decrypt(byte[] contentArray, SecretKey secretKey)throws Exception{
        byte[] result = aes(contentArray, Cipher.DECRYPT_MODE, secretKey);
        return new String(result, charsetName);
    }

    private static byte[] aes(byte[] contentArray, int mode, SecretKey secretKey) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(mode, secretKey);
        byte[] result = cipher.doFinal(contentArray);
        return result;
    }

    public static void main(String[] args) throws Exception {
        String content = "12312123123";
        SecretKey secretKey = generateKey();
        byte[] encryptResult = encrypt(content, secretKey);
        System.out.println(encryptResult);
        System.out.println(new String(encryptResult,charsetName));
        System.out.println("解密后的结果");
        String res = decrypt(encryptResult, secretKey);
        System.out.println(res);

    }
}
