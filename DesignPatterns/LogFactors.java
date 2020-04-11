package DesignPatterns;

import DesignPatterns.DatabaseLog;
import DesignPatterns.FileLog;

public class LogFactors {

    public static Operation createOperate(int choice) {
        //选择为1 就使用数据库日志
        if (choice == 1) {
            //具体实现代码....
            return new DatabaseLog("数据库日志");
            //选择为2 就使用数据库日志
        } else if (choice == 2) {
            return new FileLog("文件日志");
            //没有就抛异常
        } else {
            throw new RuntimeException("暂时还没有这种日志来服务");
        }
    }
}
