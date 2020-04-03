package realize;

import process.Init;

public class Sjf implements IprocessContral {
    @Override
    public void processContral(Init init) {
        init.sort();
        int temover = init.processes[0].insertTime;
        for (int i = 0; i < init.processes.length; i++) {

            int effect = init.effective(temover, i);  //查看进来了几个进程
            init.sort1(i, effect); //对进来的进程对短进程排序
            if (temover >= init.processes[i].insertTime) {
                init.processes[i].startTime = temover;
                init.processes[i].overTime = init.processes[i].startTime + init.processes[i].serviceTime;
                temover = init.processes[i].overTime;
            } else {
                init.processes[i].startTime = init.processes[i].insertTime;
                init.processes[i].overTime = init.processes[i].startTime + init.processes[i].serviceTime;
                temover = init.processes[i].overTime; //记住他的结束时间.
            }
        }
        init.computationTime();
    }
}
