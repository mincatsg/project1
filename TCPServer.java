package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private  static final  int PORT = 9999;
    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);

        //循环获取新的客户端连接

        while(true) {
            //阻塞,等待新的客户端连接
            Socket socket = serverSocket.accept(); //返回Socket连接的对象

            //处理这个客户端连接的业务,这个业务可能会发生阻塞.
            //先不考虑阻塞的实现.
            InputStream is = socket.getInputStream(); //获取到的是socket帮我们包装的一个输入字节流
            //缓冲字符流BufferReader/BufferedWriter 字节流要转换为字符流,需要通过
            //InputStreamReader/OutputSteamWriter  字节字符转换流来进行转换
            //字节转为缓冲的字符流。
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            OutputStream os = socket.getOutputStream();//获取到的是socket帮我们包装的一个输出字节流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

           //1.先接受客户端传来的数据,并打印
           //2.响应给客户端一个数据,我已经接受到xxx消息

            //阻塞等待客户端传过来的新的一行数据
           String line;
           while((line = br.readLine()) != null){
               System.out.println("服务器接受到数据: " +line);
               bw.write("我己经收到了" +line+ "消息");
               //需要刷新一下缓冲区
               bw.flush();
           }




        }
    }
}
