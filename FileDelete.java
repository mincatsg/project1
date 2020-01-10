package MyFile;

import java.io.File;

public class FileDelete {

    public static void main(String[] args) {
        String path = "E:\\火线时刻\\";
        String name = "mm.txt";
        String pathname = path + name;

        File file = new File(pathname);
        boolean res = file.exists();
        System.out.println("文件" + pathname + "是否存在: " + res);

        res = file.isFile();
        System.out.println("文件" + pathname + "是否是文件: " + res);

        res = file.isDirectory();
        System.out.println("文件" + pathname + "是否是目录: " + res);

        file.delete();

        if(file.exists()){
            System.out.println("删除未成功");
        }else{
            System.out.println("删除成功");
        }
    }
}
