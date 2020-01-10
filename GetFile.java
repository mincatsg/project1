package MyFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class GetFile {
    public static void main(String[] args) {
        String path = "E:\\火线时刻\\";
        String name = "mm.txt";
        String pathname = path + name;

        File file = new File(pathname);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("文件 " + name + " size " + file.length());

        System.out.println("文件 " + name + " 最近修改时间 " + new Date(file.lastModified()));
    }
}
