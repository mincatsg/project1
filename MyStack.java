package Stack;

public class MyStack {
    private int[] arr= new int[100];
    private int size = 0;

    public void push(int x){
        arr[size++] = x;
    }
    public Integer pop(){
        if(size() == 0){
            return null;
        }
        return arr[--size];
    }

    public Integer peek(){
        if(size() == 0){
            return null;
        }
        return arr[size - 1];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
