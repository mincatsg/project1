class DlinkedNode{
    public int data;
    public DlinkedNode next = null;
    public DlinkedNode prev = null;

    public DlinkedNode(int data) {
        this.data = data;
    }
}

public class DLinkedList {
    private DlinkedNode head = new DlinkedNode(-1);
    public DLinkedList(){
        this.head.next = this.head;
        this.head.prev = this.head;
    }
    public void addFirst(int data){
        DlinkedNode node = new DlinkedNode(data);
        DlinkedNode next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = next;
        next.prev = node;
    }
    public void addLast(int data){
        DlinkedNode node = new DlinkedNode(data);
        DlinkedNode prev = this.head.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.head;
        this.head.prev = node;
    }
    public boolean addIndex(int index,int data){  //任意位置插入,第一个数据节点为0号下标
        int len = size();
        if(index < 0 || index > len){
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        if(index == len){
            addLast(data);
            return true;
        }
        DlinkedNode node = new DlinkedNode(data);
        DlinkedNode cur = this.head;   //index结点
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        DlinkedNode prev = cur.prev;  //前一个结点
        prev.next = node;
        node.prev = prev;
        node.next = cur;
        cur.prev = node;
        return true;
    }
    public boolean contains(int key){ //查找是否包含关键字key是否在单链表当中
        for(DlinkedNode cur = this.head.next; cur != this.head; cur = cur.next){
            if(cur.data == key){
                return true;
            }
        }
        return false;
    }
    public void remove(int key){//删除第一次出现关键字为key的节点
        for(DlinkedNode cur = this.head.next; cur != this.head; cur = cur.next){
            if(cur.data == key){
                DlinkedNode prev = cur.prev;
                DlinkedNode next = cur.next;
                prev.next = next;
                next.prev = prev;
                return;
            }
        }
        System.out.println("无这个结点");
    }
    public void removeAllKey(int key){//删除所有值为key的节点
            DlinkedNode cur = this.head.next;
        while(cur !=  this.head){
            if(cur.data == key){
                DlinkedNode prev = cur.prev;
                DlinkedNode next = cur.next;
                prev.next = next;
                next.prev = prev;
                cur = prev.next;
            } else{
                cur = cur.next;
            }
        }
    }
    public int size(){
        int size = 0;
        for(DlinkedNode cur = this.head.next; cur != this.head; cur = cur.next){
            size++;
        }
        return size;
    }
    public void display() {
        System.out.print("[");
        for (DlinkedNode cur = this.head.next; cur != this.head; cur = cur.next) {
            if (cur.next != this.head) {
                System.out.print( cur.data+"," );
            } else {
                System.out.print( cur.data);
            }
        }
        System.out.println("]");
    }
    public void clear(){
        this.head.next = this.head;
        this.head.prev = this.head;
    }
    public static void main(String[] args) {
        DLinkedList Test = new DLinkedList();
        Test.addFirst(1);
        Test.addFirst(2);
        Test.addFirst(3);
        Test.addFirst(4);
        Test.addFirst(5);
        Test.addLast(6);
        Test.display();
        Test.addIndex(4,9);
        System.out.println(Test.contains(6));
        Test.display();
        Test.remove(6);
        Test.display();
        Test.addFirst(5);
        Test.addFirst(5);
        Test.addIndex(4,5);
        Test.addLast(5);
        Test.display();
        Test.removeAllKey(5);
        Test.display();
        System.out.println(Test.size());
        Test.clear();
        Test.display();
    }
}
