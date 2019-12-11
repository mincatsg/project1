package lower;

import java.util.LinkedList;
import java.util.Scanner;
public class Test2{
    private int size;//内存大小
    private static final int MIN_SIZE = 5;//最小剩余分区大小
    private LinkedList<Zone> zones;//内存分区
    private int pointer;//上次分配的空闲区位置

    class Zone{     //分区结点信息类
        private int size;//分区大小
        private int head;//分区起始位置
        private boolean isFree;//空闲状态

        public Zone(int head, int size) {
            this.head = head;
            this.size = size;
            this.isFree = true;
        }
    }

    /**
     * 默认内存大小为 100 KB
     */
    public Test2(){
        this.size = 400;
        this.pointer = 0;
        this.zones = new LinkedList<>();
        zones.add(new Zone(0, size));
    }
    public Test2(int size) {
        this.size = size;
        this.pointer = 0;
        this.zones = new LinkedList<>();
        zones.add(new Zone(0, size));
    }

    public void allocation(int size){//分配内存;
        System.out.print("请选择分配算法:");
        System.out.println("1.首次适应算法");
        System.out.println("2.循环首次算法");
        System.out.println("3.最佳适应算法");
        System.out.println("4.最坏适应算法");
        Scanner in = new Scanner(System.in);
        int chooce = in.nextInt();
        switch (chooce){
            case 1:
                fristFit(size);break;
            case 2:
                nextFit(size);break;
            case 3:
                bestFit(size);break;
            case 4:
                worstFit(size);break;
            default:
                System.out.println("请重新选择!");
        }
    }

    private void fristFit(int size){ //首次适应
        for (pointer = 0; pointer < zones.size(); pointer++){
            Zone tmp = zones.get(pointer);
            //找到可用分区（空闲且大小足够）
            if (tmp.isFree && (tmp.size > size)){
                doAllocation(size, pointer, tmp);
                return;
            }
        }
        //遍历结束后未找到可用分区, 则内存分配失败
        System.out.println("无可用内存空间!");
    }

    private void nextFit(int size){//循环首次
        //从上次分配空闲区位置开始遍历分区链表
        Zone tmp = zones.get(pointer);
        if (tmp.isFree && (tmp.size > size)){
            doAllocation(size, pointer, tmp);
            return;
        }
        int len = zones.size();
        int i = (pointer + 1) % len;
        for (; i != pointer; i = (i+1) % len){
            tmp = zones.get(i);
            //找到可用分区（空闲且大小足够）
            if (tmp.isFree && (tmp.size > size)){
                doAllocation(size, i, tmp);
                return;
            }
        }
        //遍历结束后未找到可用分区, 则内存分配失败
        System.out.println("无可用内存空间!");
    }

    /**
     * 最佳适应算法
     * @param size 指定需要分配的大小
     */
    private void bestFit(int size){
        int flag = -1;
        int min = this.size;
        for (pointer = 0; pointer < zones.size(); pointer++){
            Zone tmp = zones.get(pointer);
            if (tmp.isFree && (tmp.size > size)){
                if (min > tmp.size - size){
                    min = tmp.size - size;
                    flag = pointer;
                }
            }
        }
        if (flag == -1){
            System.out.println("无可用内存空间!");
        }else {
            doAllocation(size, flag, zones.get(flag));
        }
    }

    /**
     * 最坏适应算法
     * @param size 指定需要分配的大小
     */
    private void worstFit(int size){
        int flag = -1;
        int max = 0;
        for (pointer = 0; pointer < zones.size(); pointer++){
            Zone tmp = zones.get(pointer);
            if (tmp.isFree && (tmp.size > size)){
                if (max < tmp.size - size){
                    max = tmp.size - size;
                    flag = pointer;
                }
            }
        }
        if (flag == -1){
            System.out.println("无可用内存空间!");
        }else {
            doAllocation(size, flag, zones.get(flag));
        }
    }

    private void doAllocation(int size, int location, Zone tmp) {
        //size 作业大小 location 内存位置 tmp可用空闲区
        //如果分割后分区剩余大小过小（MIN_SIZE）则将分区全部分配，否则分割为两个分区
        Zone newHome = new Zone(tmp.head + size, tmp.size - size);

        zones.add(location + 1, newHome);
        tmp.size = size;
        tmp.isFree = false;
        System.out.println("成功分配 " + size + "KB 内存!");
    }


    public void collection(int id){//id 指定要回收的分区号
        if (id >= zones.size()){
            System.out.println("无此分区编号!");
            return;
        }
        Zone tmp = zones.get(id);
        int size = tmp.size;
        if (tmp.isFree) {
            System.out.println("指定分区未被分配, 无需回收");
            return;
        }
        //如果回收分区不是尾分区且后一个分区为空闲, 则与后一个分区合并
        if (id < zones.size() - 1 && zones.get(id + 1).isFree){
            Zone next = zones.get(id + 1);
            tmp.size += next.size;
            zones.remove(next);
        }
        //如果回收分区不是首分区且前一个分区为空闲, 则与前一个分区合并
        if (id > 0 && zones.get(id - 1).isFree){
            Zone previous = zones.get(id - 1);
            previous.size += tmp.size;
            zones.remove(id);
            id--;
        }
        zones.get(id).isFree = true;
        System.out.println("内存回收成功!, 本次回收了 " + size + "KB 空间!");
    }
    public void showZones(){//展示内存分区状况
        System.out.println("------------------------------------");
        System.out.println("分区编号\t分区始址\t分区大小\t空闲状态\t");
        System.out.println("------------------------------------");
        for (int i = 0; i < zones.size(); i++){
            Zone tmp = zones.get(i);
            System.out.println(i + "\t\t" + tmp.head + "\t\t" +
                    tmp.size + "  \t" + tmp.isFree);
        }
        System.out.println("------------------------------------");
    }

}