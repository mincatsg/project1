package lower;

import java.util.Scanner;

public class Main {
    public static  Test2 user;
    public static void main(String[] args) {
        Init();
        Scanner sc=new Scanner(System.in);
        while(true) {
            menu();
            int chice=sc.nextInt();
            if(chice == 4){
                return;
            }else if(chice == 1){
                System.out.println("请输入你要插入的内存块大小");
                int length=sc.nextInt();
                user.allocation(length);
            }else if(chice==2){
                System.out.println("请输入你要回收的分区号码");
                int ID=sc.nextInt();
                user.collection(ID);
            }else if(chice == 3){
                user.showZones();
            }else{
                System.out.println("输入错误，请检查");
            }
        }
    }
    public static void Init(){ //初始化内存大小
        System.out.println("请输入内存大小(如果输入0，则按默认400分配)");
        Scanner scanner=new Scanner(System.in);
        int choose=scanner.nextInt();
        if(choose==0){
            user=new Test2();
        }else {
            user=new Test2(choose);
        }
    }
    public static void menu(){
        System.out.println("***********************");
        System.out.println("*1.输入作业            *");
        System.out.println("*2.回收内存块      *");
        System.out.println("*3.展示分区情况         *");
        System.out.println("*4.退出系统            *");
        System.out.println("***********************");
        System.out.println("请输入你要进行的操作");
    }
}
