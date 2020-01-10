package MyFile;

import java.io.File;
import java.io.IOException;

public class DirectoryParent {

    public static void main(String[] args) {
        String path = "E:\\火线时刻\\";
        String dir_name = "mm";
        String pathname = path + dir_name;

        File file = new File(pathname); //子目录

        //获取父目录路径
        System.out.println(file.getParent());

        //获取父目录对象并且在父母录下创建新文件
        File pfile = file.getParentFile();

        if(!pfile.exists()){
            pfile.mkdir();
            System.out.println("路径" + pfile.getAbsolutePath() + "不存在，创建");
        }

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
