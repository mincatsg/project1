package package1109;

import java.util.Arrays;

public class Heap {
    // 在 array 中, [0, size) 的部分是一个堆结构
    // index 从哪个位置开始下沉
    // 以大堆为例
    // 借助向下调整的操作来建堆
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            // child 本来是左子树的下标, 再 + 1 就是右子树下标
            // 在找左子树和右子树谁大
            if (child + 1 < size
                    && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // if 之后 child 不知道它是左还是右了, 而一定是左右中的最大值
            if (array[child] > array[parent]) {
                // 不符合大堆的特性, 交换 child 和 parent 的位置
                swap(array, child, parent);
            } else {
                // 如果发现满足堆的特性, 调整就结束了
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    // 要把 [0, size) 范围中的元素建成堆
    public static void createHeap(int[] array, int size) {
        // 从最后一个非叶子节点出发, 从后往前走, 针对每个节点, 进行向下调整
        // 第一个 size - 1 是为了找到最后一个元素的下标
        // 再在最后一个元素下标的基础上再 - 1 再除以 2
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        // 大堆
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        createHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
