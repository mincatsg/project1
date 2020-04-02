package realize;

import process.Init;
import process.Process;


public class Fcfs implements IprocessContral {
    @Override
    public void processContral(Init init) {
               //先来先服务进程调度算法
            init.sort();
            int temover = 0; //记住每次进程的结束时间.作为下次的开始时间.
            for(int i = 0; i < init.processes.length; i++){
                if(i == 0){
                    init.processes[i].startTime = init.processes[i].insertTime;
                    init.processes[i].overTime = init.processes[i].startTime + init.processes[i].serviceTime;
                    temover = init.processes[i].overTime; //记住他的结束时间.
                }else{
                    //如果上一个结束时间比这个进程进入时间大,则这个进程已经进入,
                    // 需要等待到temover时间才能开始,直接使用temover作为这个进程的开始时间
                    if(temover >= init.processes[i].insertTime){
                        init.processes[i].startTime = temover;
                        init.processes[i].overTime = init.processes[i].startTime + init.processes[i].serviceTime;
                        temover = init.processes[i].overTime;
                    }else{
                        //否则这个进程还没有进入,需要等到这个进程的进入时间才能开始
                        init.processes[i].startTime = init.processes[i].insertTime;
                        init.processes[i].overTime = init.processes[i].startTime + init.processes[i].serviceTime;
                        temover = init.processes[i].overTime; //记住他的结束时间.
                    }
                }
                init.computationTime();  //计算周转时间和带权周转时间
            }
        }
}
