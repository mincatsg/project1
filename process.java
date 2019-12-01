package ProcessScheduling;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class process {
    static class proces {
       public String name;   //进程标识符
       public int insertTime;   //进入时间
         public int serviceTime;  //服务时间
      public   int startTime;  //开始时间
        public  int overTime;  //完成时间
        public int turnoverTime; //周转时间
        public double turnAroundTime; //带权周转时间

    }
    proces[] processes;
    public  void  init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("你要输入的进程数");
        int amount = scanner.nextInt();
        processes = new proces[amount];
        for(int i = 0; i < amount; i++){
            System.out.println("第" + (i+1) + "进程是:");
            System.out.println("你的进程名是:");
            processes[i] = new proces();
            processes[i].name = scanner.next();
            System.out.println("你的进入时间是:");
            processes[i].insertTime = scanner.nextInt();
            System.out.println("你的估计运行时间是");
            processes[i].serviceTime = scanner.nextInt();
        }
    }

    public void sort(){  //根据进入时间直接选择排序
        for(int i = 0; i < processes.length; i++){
            for(int j = i + 1; j < processes.length; j++){
                if(processes[i].insertTime > processes[j].insertTime){
                    proces tem = processes[i];
                    processes[i] = processes[j];
                    processes[j] = tem;
                }
            }
        }
    }
    public int effective(int temover, int start){ //查看短进程有效值
        int end;  //去返回有效值的下标
        for(end = start; end < processes.length; end++){
            if(processes[end].insertTime > temover){
                break;
            }
        }
        return end;
    }
    public void sort1(int start, int end){ //根据服务时间排序
        for(int i = start; i < end; i++){
            for(int j = i + 1; j < end; j++){
                if(processes[i].serviceTime > processes[j].serviceTime){
                    proces tem = processes[i];
                    processes[i] = processes[j];
                    processes[j] = tem;
                }
            }
        }
    }
    public void sort2(int start, int end, int temover){//根据优先级排序
        for(int i = start; i < end; i++){
            for(int j = i + 1; j < end; j++){
                int now =  (temover - processes[i].insertTime + processes[i].serviceTime) / processes[i].serviceTime;
                int next = (temover - processes[j].insertTime + processes[j].serviceTime) / processes[j].serviceTime;
                if(next > now){
                    proces tem = processes[i];
                    processes[i] = processes[j];
                    processes[j] = tem;
                }
            }
        }
    }
    public void print(){
        System.out.println("| 作业 | 进入时间 | 估计运行时间 | 开始时间 | 结束时间 | 周转时间 | 带权周转时间 |");
        System.out.println("----------------------------------------------------------------------------------------------");
        for(int i = 0; i < processes.length; i++){
            System.out.print("|   " + processes[i].name + "  |");
            System.out.print("   " + processes[i].insertTime + "      |");
            System.out.print("      " + processes[i].serviceTime + "       |");
            System.out.print("     " + processes[i].startTime + "    |");
            System.out.print("    " + processes[i].overTime + "     |");
            System.out.print("    " + processes[i].turnoverTime + "     |");
            System.out.println("       " + processes[i].turnAroundTime + "    |");
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }
    public void FCFS(){   //先来先服务进程调度算法
        sort();
        int temover = 0; //记住每次进程的结束时间.作为下次的开始时间.
        for(int i = 0; i < processes.length; i++){
            if(i == 0){
                processes[i].startTime = processes[i].insertTime;
                processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                temover = processes[i].overTime; //记住他的结束时间.
            }else{
                //如果上一个结束时间比这个进程进入时间大,则这个进程已经进入,
                // 需要等待到temover时间才能开始,直接使用temover作为这个进程的开始时间
                if(temover >= processes[i].insertTime){
                processes[i].startTime = temover;
                processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                temover = processes[i].overTime;
            }else{
                    //否则这个进程还没有进入,需要等到这个进程的进入时间才能开始
                processes[i].startTime = processes[i].insertTime;
                processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                temover = processes[i].overTime; //记住他的结束时间.
            }
        }
        computationTime();  //计算周转时间和带权周转时间
      }
    }
    public void computationTime(){  //计算周转时间和带权周转时间
        for(int i = 0; i < processes.length; i++){
            processes[i].turnoverTime = processes[i].overTime - processes[i].insertTime;
            processes[i].turnAroundTime = (double)processes[i].turnoverTime / processes[i].serviceTime;
        }
    }

    public void SJF() { //短进程优先算法
        sort();
        int temover = 0;
        for (int i = 0; i < processes.length; i++) {
            if (i == 0) {
                processes[i].startTime = processes[i].insertTime;
                processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                temover = processes[i].overTime; //记住他的结束时间.
            } else {
                int effect = effective(temover,i);  //查看进来了几个进程
                sort1(i,effect); //对进来的进程对短进程排序
                if (temover >= processes[i].insertTime) {
                    processes[i].startTime = temover;
                    processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                    temover = processes[i].overTime;
                } else {
                    processes[i].startTime = processes[i].insertTime;
                    processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                    temover = processes[i].overTime; //记住他的结束时间.
                }
            }
            computationTime();  //计算周转时间和带权周转时间
        }
    }
    public void priority(){ //优先级算法
       sort();
        int temover = 0;
        for (int i = 0; i < processes.length; i++) {
            if (i == 0) {
                processes[i].startTime = processes[i].insertTime;
                processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                temover = processes[i].overTime; //记住他的结束时间.
            } else {
                int effect = effective(temover,i);  //查看进来了几个进程
                sort2(i,effect, temover); //对进来的进程进行优先级排序
                if (temover >= processes[i].insertTime) {
                    processes[i].startTime = temover;
                    processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                    temover = processes[i].overTime;
                } else {
                    processes[i].startTime = processes[i].insertTime;
                    processes[i].overTime = processes[i].startTime + processes[i].serviceTime;
                    temover = processes[i].overTime; //记住他的结束时间.
                }
            }
            computationTime();  //计算周转时间和带权周转时间
        }
    }

    public void RR(){
        sort();  //先按进入时间排个序
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输出你的RR是多少:");
        int RR = scanner.nextInt();
        int temover = processes[0].insertTime;  //记录上个进程结束时间
       Queue<Integer> queue = new LinkedList<>();  //建一个队列去更新进来的进程,模拟进程调度
        int[] serviceTem = new int[processes.length]; //存放所有的进程估计运行时间的,开始全为0.
        int i = 1; //看队列进了几个进程了
        queue.offer(0); //排完序,肯定先执行第一个.
        while(!queue.isEmpty() || (i < processes.length)){
            //RR值重新给一下
            int cur = RR;
            //如果某一个当某一个进程执行完之后,但后面的进程还没有入队,就会有队列为空的表现.
            // 所以他就得再次执行陷入先服务，所以我们得给队列手动进入后面的进程.
            if(queue.isEmpty()) {
                for (int tep = 0; tep < serviceTem.length; tep++){
                    if(serviceTem[tep] == 0){
                        i = i + 1;
                        temover = processes[tep].insertTime;   //更改下结束时间
                        queue.offer(tep);
                        break;
                    }
                }
            }
           //出队,进行执行
            int tem = queue.poll();
            if(serviceTem[tem] == 0){  //当数组里估计运行时间为0的话,那就是第一次初始化,可以赋一下初始值.
                processes[tem].startTime = temover;
            }
            while(cur != 0){   //模拟实现加时间片轮转,执行RR次,直到相等或用完。
                if(serviceTem[tem] != processes[tem].serviceTime){
                        ++serviceTem[tem];
                        temover++;
                }
                if(serviceTem[tem] == processes[tem].serviceTime) {
                    processes[tem].overTime = temover;
                    break;
                }
               cur--;
            }
            //注意我这个进程进入顺序.
            //i记录进程个数,去遍历所有进程,看还有那个没进入,如果进程到了,就插入队列.
            if(i < processes.length) {
                int j = i;
                for (; j < processes.length; j++) {
                    if (processes[j].insertTime <= temover) {
                        queue.offer(j);
                        i = i + 1;
                    }
                }
            }
            //如果当前进程没有执行完,就在进入队列.
            if(serviceTem[tem] != processes[tem].serviceTime) {
                queue.offer(tem);
            }
        }
           computationTime();
    }
    public void menu() {
        System.out.println("欢迎来到进程调度");
        System.out.println("***********************");
        System.out.println("*****1.初始化**********");
        System.out.println("*****2.FCFS算法********");
        System.out.println("*****3.SJF算法*********");
        System.out.println("*****4.优先级算法******");
        System.out.println("*****5.RR算法**********");
        System.out.println("*****6.exit************");
        System.out.println("***********************");
    }
    public  void perform(){
    Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(true) {
            menu();
            System.out.println("请输入你的选择");
            choice = scanner.nextInt();
            if (choice == 1) {
                init();
            } else if (choice == 2) {
                System.out.println("FCFS算法结果:");
                FCFS();
            } else if (choice == 3) {
                System.out.println("SJF算法结果:");
                SJF();
            } else if (choice == 4){
                System.out.println("优先级算法结果:");
                priority();
            }
            else if(choice == 5){
                System.out.println("RR算法结果:");
                RR();
            }
            else if (choice == 6) {
                System.out.println("Good bye !!!");
                   break;
            }
            else{
                System.out.println("你的输入有误,请重输");
                continue;
                }
            print();
            }
        }
    public static void main(String[] args) {
        process m1 = new process();
        m1.perform();
    }
}
