package FacadePattern;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Client {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        EncryptFacade facade = new EncryptFacade();
        String src = "E:\\Java\\schoolTest\\src\\FacadePattern\\test.txt";
        String des = "E:\\Java\\schoolTest\\src\\FacadePattern\\des.txt";
        facade.fileEncrypt(src,des);
    }

}
