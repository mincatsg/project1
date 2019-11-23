package Queue;

class Node{
    public int val;
    public Node next = null;

    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {
    private Node head = null;
    private Node Tail = null;
    private int size = 0;

    public void offer(int x){
        Node node = new Node(x);
        if(Tail == null){
            head = node;
        }else{
            Tail.next = node;
        }
        Tail = node;
        size++;
    }
    public int poll(){
        if(size == 0){
            throw  new RuntimeException("队列为空");
        }
        int res = head.val;
        head = head.next;
        if(head == null){
            Tail = null;
        }
        size--;
        return res;
    }
    public int peek(){
        if(size == 0){
            throw  new RuntimeException("队列为空");
        }
        return head.val;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
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
