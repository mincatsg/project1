package MyFile;

import java.io.File;

public class DirectoryCreate {

    public static void main(String[] args) {
        String path = "E:\\火线时刻\\";
        String dir_name = "mm";
        String pathname = path + dir_name;

        File file = new File(pathname);
        if(file.exists()){
            System.out.println("路径已经存在，不需创建");
        }else{
            file.mkdir();
            System.out.println("空目录创建成功");
        }

    }
}
