package FacadePattern;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileReader {

    public static String read(String fileNameSrc) throws IOException{
        FileReader fr = new FileReader(fileNameSrc);
        //FileReader fr = new FileReader("F:\\Java程序\\designMode\\src\\FacadePattern\\test.txt");
        //FileWriter fw = new FileWriter("F:\\Java程序\\designMode\\src\\FacadePattern\\des.txt");
        int ch;
        StringBuffer str = new StringBuffer();
        while((ch=fr.read())!=-1) {
            str.append((char) ch);
            //fw.write(ch);
        }

        //fw.close();
        fr.close();
       return str.toString();
   }

    public static void main(String[] args) throws IOException {
       String s =  read("F:\\Java程序\\designMode\\src\\FacadePattern\\test.txt");
        System.out.println(s);
    }



}
