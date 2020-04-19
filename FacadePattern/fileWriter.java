package FacadePattern;


import java.io.FileWriter;
import java.io.IOException;

public class fileWriter {
    public void write(String encryptText, String fileNameDes) throws IOException {
        FileWriter fw = new FileWriter(fileNameDes);
        for(int i = 0; i < encryptText.length(); i++){
            fw.write(encryptText.charAt(i));
        }
        fw.close();
    }
}
