package FacadePattern;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class EncryptFacade {

    private fileReader reader;
    private CipherMachine cipher;
    private fileWriter writer;
    public EncryptFacade() {
        reader = new fileReader();
        cipher = new CipherMachine();
        writer = new fileWriter();
    }
    public void fileEncrypt(String fileNameSrc, String fileNameDes) throws IOException, NoSuchAlgorithmException {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr,fileNameDes);
    }
}
