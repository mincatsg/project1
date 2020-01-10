package MyFile;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File file  = new File("D:\\新建文件夹");

        boolean res = file.exists();
        System.out.println("文件" +  "是否存在: " + res);

        res = file.isDirectory();
        System.out.println("文件"  + "是否是目录: " + res);

        res = file.isFile();
        System.out.println("文件"  + "是否是文件: " + res);

        
    }

}
