package Queue;

public class ArrayMyQueue {
    private int[] arr = new int[100];
    private int size = 0;
    private int head = 0;
    private int Tail = size;


    public boolean offer(int x){
        if(size == arr.length ){
            return false;
        }
        arr[Tail++] = x;
        if(Tail == arr.length){
            Tail = 0;
        }
        size++;
        return true;
    }

    public Integer poll(){
        if(size == 0){
            return null;
        }
        Integer ret = arr[head];
        head++;
        if (head == arr.length) {
            head = 0;
        }
        size--;
        return ret;
    }
   public Integer peek(){
       if(size == 0){
           return null;
       }
       return arr[head];
   }
   public boolean isEmpty(){
        return size == 0;
   }
   public int size(){
        return size;
   }

    public static void main(String[] args) {
        ArrayMyQueue queue = new ArrayMyQueue();
        System.out.println(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
