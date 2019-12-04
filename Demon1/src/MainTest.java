
import process.*;
import realize.*;

import java.lang.Process;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        IprocessContral[] chooseProcess = new IprocessContral[]{
                new Fcfs(),
                new Sjf(),
                new Psa(),
                new Rr()
        };
        Init init = new Init();// 创建一个对象
        while (true){
            menu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1){
                init.initMessage();
            }else if(choice == 2){
                chooseOneAlgo(chooseProcess, init);
                show(init);
            } else if(choice == 3){
                System.out.println("退出成功！");
                System.exit(-1);
            } else{
                System.out.println("无此选项！");
            }
        }
    }

    private static void show(Init init){
        System.out.println("|进程名|进入时间|服务时间|开始时间|优先级|时间片|结束时间|周转时间|带权周转时间|");
        for(int i = 0; i < init.processes.length; i++){
            System.out.println(init.processes[i]);
        }
    }
    public static void menu(){
        System.out.println("*************************");
        System.out.println("***** 1.录入信息     ****");
        System.out.println("***** 2.选择调度算法 ****");
        System.out.println("***** 3.退出         ****");
        System.out.println("*************************");
    }

    public static void chooseOneAlgo(IprocessContral[] chooseProcess, Init init){
        menu1();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 1 || choice == 2 || choice == 3 || choice == 4){
            chooseProcess[choice - 1].processContral(init);
        }
    }
    public static void menu1(){
        System.out.println("***************************");
        System.out.println("**** 1.先来先服务算法  ****");
        System.out.println("**** 2.短进程优先算法  ****");
        System.out.println("**** 3.高优先级算法    ****");
        System.out.println("**** 4.时间片轮转      ****");
        System.out.println("****************************");
    }
}
