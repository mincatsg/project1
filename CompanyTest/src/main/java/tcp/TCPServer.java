package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    private static final int PORT = 9999;

//    private static final ThreadPoolExecutor POOL = new ThreadPoolExecutor(
//            0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS,
//            new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy()
//    );

    // 线程池中使用的线程，在参数3+4的时间范围内，是可以重用
    // 有新任务进来需要处理，此时有正式工线程空闲，就让正式工处理
    // 如果正式工都没有空闲，让临时工处理（依赖具体是哪种线程池的实现）
    // 就创建新的线程处理（是否创建需要依赖具体是哪种线程池的实现）（新的线程加入正式工或者临时工）

    // 可缓存的线程：正式工编制为0，所有线程都是临时工
    private static final ExecutorService EXE = Executors.newCachedThreadPool();


    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);


        //循环获取新的客户端连接

        while (true) {

            //阻塞,等待新的客户端连接
            Socket socket = serverSocket.accept(); //返回Socket连接的对象

            EXE.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //处理这个客户端连接的业务,这个业务可能会发生阻塞.
                        //先不考虑阻塞的实现.
                        InputStream is = socket.getInputStream(); //获取到的是socket帮我们包装的一个输入字节流
                        //缓冲字符流BufferedReader/BufferedWriter 字节流要转换为字符流,需要通过
                        //InputStreamReader/OutputSteamWriter  字节字符转换流来进行转换
                        //字节转为缓冲的字符流。
                        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                        OutputStream os = socket.getOutputStream();//获取到的是socket帮我们包装的一个输出字节流
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                        //1.先接受客户端传来的数据,并打印
                        //2.响应给客户端一个数据,我已经接受到xxx消息

                        //阻塞等待客户端传过来的新的一行数据
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println("服务器已经接受到状态码: " + line + "正在为你读取数据");
                            line = ReadFile.Information(line);
                            bw.write(line + "\n");
                            //需要刷新一下缓冲区
                            bw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


        }
    }
}
