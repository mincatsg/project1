import org.junit.Test;

import java.io.*;

/**
 * 1.IO流操作，使用完毕要关闭流（释放资源）
 * 2.任何流，读取完的地方不能再次读取
 * 3.使用Buffered缓冲流，需要刷新。
 * 4.Buffered缓冲流，网络Socket IO操作时，操作完毕，或者结束
 */
public class FileIOTest {

    @Test
    public void t0() {
        FileInputStream fis = null;
        try {
            try {
                File file = new File("D:\\Workspaces\\Java12\\io-demo\\resources\\user\\abc.txt");
                //字节流读取文本的时候，如果Java文件和目标文件编码一致，可以正常读取
                //如果编码不一致，就是乱码
                fis = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int idx;
                while((idx=fis.read(bytes)) != -1){// 读取到数组，-1表示读完
                    System.out.println(new String(bytes, 0, idx));
                }
            } finally {
                if(fis != null)
                    fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t0_0() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            try {
                is = FileIOTest.class.getClassLoader()
                        .getResourceAsStream("user/abc.txt");
                isr = new InputStreamReader(is,
                        "GBK");
                br = new BufferedReader(isr);
                String line;
                while((line=br.readLine()) != null){//按行读取，为null表示读完
                    System.out.println(line);
                }
            } finally {
                if(br != null)
                    br.close();
                if(isr != null)
                    isr.close();
                if(is != null)
                    is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t1() throws IOException {
        File file = new File("D:\\Workspaces\\Java12\\out\\production\\io-demo\\user\\abc.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(
                fis, "UTF-8");
//        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
        String line;
        while((line=br.readLine()) != null){//按行读取，为null表示读完
            System.out.println(line);
        }
    }

    @Test
    public void t2() throws IOException {
        File file = new File("D:\\Workspaces\\Java12\\out\\production\\io-demo\\user\\abc.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(
                fis, "UTF-8");
//        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
        char[] chars = new char[1024];
        int idx;
        while((idx=br.read(chars)) != -1){// 读取到数组，-1表示读完
            System.out.println(new String(chars, 0, idx));
        }
    }

    @Test
    public void t3() throws IOException {
        File file = new File("D:\\Workspaces\\Java12\\io-demo\\resources\\user\\abc.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        OutputStreamWriter os = new OutputStreamWriter(fos,
//                "UTF-8");
//        BufferedWriter writer = new BufferedWriter(os);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file),
                "UTF-8"));
        writer.write("Hello");
        writer.newLine();
        writer.write("开发");
        writer.flush();
    }
}
