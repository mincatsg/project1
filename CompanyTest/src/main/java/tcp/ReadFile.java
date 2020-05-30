package tcp;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ReadFile {
    //定义交易码集合
    private static final Set<String> set = new HashSet<>();

    //设置有的交易码
    static {
        set.add("0101");
        set.add("0202");
        set.add("0303");
    }

    //设置读取文档的路径
    private static String path = "E:\\Java\\CompanyTest\\";

    public static String Information(String transactionCode) throws IOException {
        //无交易码
        if(!set.contains(transactionCode)){
            return "交易码有误,无法交易";
        }
        //交易码存在读取文件数据返回.
        BufferedReader bReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path + transactionCode + ".txt"), "gbk"));

        //读取到数据返回
        StringBuffer sbr = new StringBuffer();
        String s = null;

        while((s = bReader.readLine()) != null) {
            sbr.append(s);
        }
        s = sbr.toString();
        bReader.close();
        return s;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Information("0202"));
    }
}
