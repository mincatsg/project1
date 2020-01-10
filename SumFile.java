package MyFile;

import java.io.File;

public class SumFile {

    public static void main(String[] args) {

        String path = "E:\\火线时刻";

        File file = new File(path);

        if(file.exists() && file.isDirectory()){

            File[] result = file.listFiles();

            for(File file1 : result){
                System.out.println(file1);
            }
        }
    }

}
