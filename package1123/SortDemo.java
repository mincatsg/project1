package package1123;

public class SortDemo {
    public void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur] < arr[cur - 1]) {
                    swap(arr, cur, cur - 1);
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    private static void quickSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition(arr, left, right);
        quickSortHelper(arr, left, index - 1);
        quickSortHelper(arr, index + 1, right);

    }

    private static int partition(int[] arr, int left, int right) {
        int index = right;
        while (left < right) {
            while (left < right && arr[left] <= arr[index]) {
                left++;
            }
            while (left < right && arr[right] >= arr[index]) {
                right--;
            }

            swap(arr, left, right);
        }
        swap(arr, left, index);
        return left;
    }


    public  static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

