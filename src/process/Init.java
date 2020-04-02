package process;


import java.util.Scanner;

public class Init {
    public  Process []processes;


    public void initMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入进程个数：");
        int number1 = scanner.nextInt();
        processes = new Process[number1];
        for(int i = 0; i < number1; i++){
            System.out.println("请输入进程" + (i + 1) + "的相关信息：");
            System.out.println("进程名   进入时间    服务时间");
            processes[i] = new Process();
            String name = scanner.next();
            processes[i].name = name;
            int inTime = scanner.nextInt();
            processes[i].insertTime = inTime;
            processes[i].serviceTime = scanner.nextInt();
        }
    }

    public void computationTime(){  //计算周转时间和带权周转时间
        for(int i = 0; i < processes.length; i++){
            processes[i].turnoverTime = processes[i].overTime - processes[i].insertTime;
            processes[i].turnAroundTime = (double)processes[i].turnoverTime / processes[i].serviceTime;
        }
    }
    public void sort(){  //根据进入时间直接选择排序
        for(int i = 0; i < processes.length; i++){
            for(int j = i + 1; j < processes.length; j++){
                if(processes[i].insertTime > processes[j].insertTime){
                    Process tem = processes[i];
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
                    Process tem = processes[i];
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
                    Process tem = processes[i];
                    processes[i] = processes[j];
                    processes[j] = tem;
                }
            }
        }
    }

}
