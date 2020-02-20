package package1109;

public class MyPriorityQueue {
    // 这个数组就是队列本体. 基于这个数组建立堆
    private int[] array = new int[100];
    // 队列中元素的个数, 堆的大小
    private int size = 0;

    public void offer(int x) {
        if (size >= array.length) {
            return;
        }
        array[size] = x;
        size++;
        shiftUp(array, size - 1);
    }

    // 复杂度是 O(logN)
    private void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (index - 1) / 2;
        while (child > 0) {
            if (array[parent] < array[child]) {
                // 交换两个元素
                swap(array, parent, child);
            } else {
                // 调整完了
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size
                && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 条件结束, 预期 child 指向左右子树的最大值
            // 再拿 child 和 parent 进行对比
            if (array[parent] < array[child]) {
                // 不满足大堆要求, 交换
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    private void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    // 堆顶元素就是返回值
    // 删除堆顶元素并不是直接删除.
    // 用最后一个元素来覆盖堆顶元素
    // 再从堆顶位置向下调整即可
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return ret;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }
}
