package MyFile;

import java.io.File;
import java.io.IOException;

public class FileCreate {

    public static void main(String[] args) {
        String path = "E:\\火线时刻\\";
        String name = "mm.txt";
        String pathname = path + name;
        System.out.println(File.separator); //该系统的分隔符.


        File file = new File(pathname);

        if(!file.exists()){  //不存在要重新建立
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("文件" + pathname + "创建失败");
            }
        }
        else{ //存在即删除
            System.out.println("文件" + pathname + "已经存在，不需创建");
            file.delete();
        }
    }
}
