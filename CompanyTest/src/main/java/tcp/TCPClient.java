package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    //    private static final String HOST = "192.168.1.4";
    //本机默认的域名就是Localhost,默认ip就是127.0.0.1
    //Localhost会通过本机c://windows/system32/drivers/hosts文件
    private static final String HOST = "localhost";
    //    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        //建立了客户端到服务器的tcp连接
        Socket socket = new Socket(HOST, PORT);


        //处理这个客户端连接的业务,这个业务可能会发生阻塞.
        //先不考虑阻塞的实现.
        InputStream is = socket.getInputStream(); //获取到的是socket帮我们包装的一个输入字节流
        //缓冲字符流BufferReader/BufferedWriter 字节流要转换为字符流,需要通过
        //InputStreamReader/OutputSteamWriter  字节字符转换流来进行转换
        //字节转为缓冲的字符流。
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        OutputStream os = socket.getOutputStream();//获取到的是socket帮我们包装的一个输出字节流
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        PrintWriter pw = new PrintWriter(os, true);
//bufferedWriter可以改造为PrintWriter(1.可以自动刷新 2.println可以不用手动加上换行符)

//        pw.println("hello, 我来了");
//        bw.write("hello,我来了\n");
//        bw.flush();

        System.out.print("请输入交易码: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); //已经去除了换行符
            //发送数据到服务端
            pw.println(line); //println发送的数据会加上换行符：发送Line + \n
            //接受服务端的响应信息
            String response = br.readLine();
            System.out.println("接收到服务器响应: " + response);
            System.out.print("请输入交易码: ");
        }
    }


}
