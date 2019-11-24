package Heap;

public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;

    public void shiftUp(int[] array, int index) {  //以大堆为例
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] >= array[index]) {
                break;
            }
            swap(array, parent, index);
            index = parent;
        }
    }
    public void shiftDown(int[] array, int size, int index){
        int child = (2 * index) + 1;
        while(child < size){
            if(child + 1 < size && array[child] < array[child + 1]){
                child = child + 1;
            }
            if(array[child] > array[index]){
                swap(array,child,index);
            }else{
                break;
            }
            index = child;
            child = (2 * index) + 1;
        }
    }
    public void swap(int[] array, int parent, int child){
        int tem = array[parent];
        array[parent] = array[child];
        array[child] = tem;
    }
    public void offer(int val){
        array[size++] = val;
        shiftUp(array,size - 1);
    }

    public Integer pop(){
        if(size == 0){
            return 0;
        }
        int oldValue = array[0];
        array[0] = array[--size];
        shiftDown(array, size, 0);
        return oldValue;
    }
    public Integer peek(){
        if(size == 0){
            return 0;
        }
        return array[0];
    }
}
