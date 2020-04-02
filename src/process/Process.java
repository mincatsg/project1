package process;

public class Process {
    public String name;   //进程标识符
    public int insertTime;   //进入时间
    public int serviceTime;  //服务时间
    public   int startTime;  //开始时间
    public  int overTime;  //完成时间
    public int turnoverTime; //周转时间
    public double turnAroundTime; //带权周转时间

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", insertTime=" + insertTime +
                ", serviceTime=" + serviceTime +
                ", startTime=" + startTime +
                ", overTime=" + overTime +
                ", turnoverTime=" + turnoverTime +
                ", turnAroundTime=" + turnAroundTime +
                '}';
    }
}
