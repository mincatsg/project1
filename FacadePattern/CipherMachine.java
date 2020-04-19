package FacadePattern;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CipherMachine {
    public String encrypt(String plainText) throws NoSuchAlgorithmException {

        //MessageDigest 方法封装了MD5和SHA算法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //调用MD5方法，就返回16个byte类型的值
        byte[] result = md5.digest(plainText.getBytes());
        return new String(result);
    }

}
