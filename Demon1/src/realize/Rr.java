package realize;

import process.Init;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rr implements IprocessContral {
    @Override
    public void processContral(Init init) {
        init.sort();  //先按进入时间排个序
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输出你的RR是多少:");
        int RR = scanner.nextInt();
        int temover = init.processes[0].insertTime;  //记录上个进程结束时间
        Queue<Integer> queue = new LinkedList<>();  //建一个队列去更新进来的进程,模拟进程调度
        int[] serviceTem = new int[init.processes.length]; //存放所有的进程估计运行时间的,开始全为0.
        int i = 1; //看队列进了几个进程了
        queue.offer(0); //排完序,肯定先执行第一个.
        while (!queue.isEmpty() || i < init.processes.length) {
            //RR值重新给一下
            int cur = RR;
            //如果某一个当某一个进程执行完之后,但后面的进程还没有入队,就会有队列为空的表现.
            // 所以他就得再次执行陷入先服务，所以我们得给队列手动进入后面的进程.
            if (queue.isEmpty()) {
                for (int tep = 0; tep < init.processes.length; tep++) {
                    if (serviceTem[tep] == 0) {
                        queue.offer(tep);
                        temover = init.processes[tep].insertTime;   //更改下结束时间
                        i = i + 1;
                        break;
                    }
                }
            }
            //出队,进行执行
            int tem = queue.poll();
            if (serviceTem[tem] == 0) {  //当数组里估计运行时间为0的话,那就是第一次初始化,可以赋一下初始值.
                init.processes[tem].startTime = temover;
            }
            while (cur != 0) {   //模拟实现加时间片轮转,执行RR次,直到相等或用完。
                if (serviceTem[tem] != init.processes[tem].serviceTime) {
                    ++serviceTem[tem];
                    temover++;
                }
                if (serviceTem[tem] == init.processes[tem].serviceTime) {
                    init.processes[tem].overTime = temover;
                    break;
                }
                cur--;
            }
            //注意我这个进程进入顺序.
            //i记录进程个数,去遍历所有进程,看还有那个没进入,如果进程到了,就插入队列.
            if (i < init.processes.length) {
                int j = i;
                for (; j < init.processes.length; j++) {
                    if (init.processes[j].insertTime <= temover) {
                        queue.offer(j);
                        i = i + 1;
                    }
                }
            }
            //如果当前进程没有执行完,就在进入队列.
            if (serviceTem[tem] != init.processes[tem].serviceTime) {
                queue.offer(tem);
            }
        }
        init.computationTime();
    }
}
