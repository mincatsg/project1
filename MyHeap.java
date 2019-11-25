package Heap;

import java.util.Arrays;

public class MyHeap {
    public static void  shiftDown(int[] array, int size, int index){ //向下调整
         int parent = index;
         int child = 2 * parent + 1; //左孩子
         while(child < size){
             if(child + 1 < size && array[child + 1] < array[child]){  //右孩子比左孩子小则孩子指向右孩子
                 child = child + 1;
             }
             //if之后child表示最小的结点。
             if(array[parent] > array[child]){
                 swap(array, parent, child);
             }else{
                  break;
             }
             parent = child;
             child = 2 * parent + 1;
         }
    }

     public static void swap(int[] array, int parent, int child){
        int tem = array[parent];
        array[parent] = array[child];
        array[child] = tem;
     }

    public static void createHeap(int[] array, int size) {
        // 从最后一个非叶子节点出发, 从后往前走, 针对每个节点, 进行向下调整
        // 第一个 size - 1 是为了找到最后一个元素的下标
        // 再在最后一个元素下标的基础上再 - 1 再除以 2
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }
   public static void shiftUp(int[] array, int index) { //向上转型,小堆为例
        int child = index;
        int parent = (child - 1) / 2;
        while(child > 0){
            if(array[parent] > array[child]){
                swap(array,parent,child);
            }else {
                break;
            }

            child  = parent;
            parent = (child - 1) / 2;
        }
   }
    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37};
//        shiftDown(array,array.length,0);
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
