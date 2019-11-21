package Sort;

import java.util.Arrays;
import java.util.Stack;

public class SortDemon {

    public static void insertSort(int[] array){ //插入排序 升序为例
        //就是将待排序元素在已排好序的元素中找，比自己大的就将大的后移，小的就将自已放到小的后面。
        for(int bound = 1; bound < array.length; bound++){
            // (bound, size)待排序数组
            // [0, bound)已排序数组
            int tem = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--){
                if(tem < array[cur]){
                    array[cur + 1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + 1] = tem;
        }
    }
    public static void shellSort(int[] array){   //希尔排序
        int gap = array.length;
        while(gap > 1){
            insertSortGap(array, gap);
            gap /= 3;
        }
        insertSortGap(array, 1);
    }
    public static void insertSortGap(int[] array, int gap){
        for(int bound = gap; bound < array.length; bound++){
            int tem = array[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur = cur - gap){
                if(tem < array[cur]){
                    array[cur + gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + gap] = tem;
        }
    }
    public static void selectSort(int[] array) { //直接选择排序
        for (int bound = 0; bound < array.length; bound++) {
            int cur = bound + 1;
            for (; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int tem = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tem;
                }
            }
        }
    }
    public static void heapsort(int[] array){  //堆排序
        creatHeap(array);
        for(int i = 0; i < array.length; i++){
            swap(array, 0, array.length - 1 - i);
            shiftDown(array,array.length - i - 1, 0);
        }
    }
    public static void creatHeap(int[] array){  //建堆
        for(int cur = (array.length - 1 - 1) / 2; cur >= 0; cur-- ){
            shiftDown(array,array.length,cur);
        }
    }
    public static void shiftDown(int[] array,int size, int index){ //向下调整
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            if(child + 1 < size && child + 1 > child){
                child = child + 1;
            }
            if(array[parent] < array[child]){
                swap(array, parent, child);
            }

            parent = child;
            child = 2 * parent + 1;
        }
    }
    public static void swap(int[] array, int left, int right){
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }

    public static void bubbleSort(int[] array){  //冒泡排序  升序
        for(int bound = 0; bound < array.length; bound++){
            //（bound,arr.length) 未排序
            // [0,bound) 已排序组合
            for(int cur = array.length - 1; cur > bound; cur--){
                if(array[cur] < array[cur - 1]){
                    swap(array, cur, cur - 1);
                }
            }
        }
    }

    public static void quickSort(int[] array) {  //递归实现快速排序
        quickSortInternal(array, 0, array.length - 1);
    }

    public static  void quickSortInternal(int[] array, int left, int right){
            if(left >= right){
               return;
           }
            // 最简单的选择基准值的方式，选择 array[right] 作为基准值
            // pivotIndex 代表基准值最终停留的下标
            int pivotIndex = partition(array, left, right);
            // [left, pivotIndex - 1] 都是小于等于基准值的
            // [pivotIndex + 1, right] 都是大于等于基准值的
            quickSortInternal(array, left, pivotIndex - 1);
            quickSortInternal(array, pivotIndex + 1, right);
        }
    public static int partition(int[] array, int left, int right){
        int baseIndex = right;
        int baseValue = array[baseIndex];
        while(left < baseIndex){
            while(left < baseIndex && array[left] <= baseValue){
                left++;
            }
            while(left < baseIndex && baseValue <= array[baseIndex]){
                baseIndex--;
            }
            swap(array, left, baseIndex);
        }
        swap(array, right, left);
        return left;
    }

    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left <= right){
                continue;
            }
            int pivotIndex = partition(array,left,right);

            //左半部分进栈
            stack.push(pivotIndex - 1);
            stack.push(left);

            //右半部分进栈
            stack.push(right);
            stack.push(pivotIndex + 1);
        }

    }

    public static void mergeSort(int[] array){
        mergeSortHelper(array, 0, array.length);
    }

    public static void mergeSortHelper(int[] array, int left, int right){
        if(left >= right || right - left == 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        mergr(array, left, mid, right);
    }

    public static void mergr(int[] array, int left, int mid, int right){
        int length = right - left;
        int[] output = new int[length];
        int outputIndex = 0;
        int i = left;
        int j = mid;
        while(i < mid && j < right){
            if (array[i] <= array[j]) {
                // i 对应的元素比 j 小
                // 就把 i 对应的元素插入到 output 末尾
                output[outputIndex++] = array[i++];
            } else {
                output[outputIndex++] = array[j++];
            }
        }

        while(i < mid){
            output[outputIndex++] = array[i++];
        }
        while(j < right){
            output[outputIndex++] = array[j++];
        }

        for(int k = 0; k < length; k++){
            array[left + k] = output[k];
        }
    }
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2, 6, 8, 7, 9};
//        insertSort(array);
//         heapsort(array);
//         bubbleSort(array);
//           quickSort(array);
//        quickSortByLoop(array);
        mergeSort(array);
        for(int x: array){
            System.out.println(x);
        }
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
