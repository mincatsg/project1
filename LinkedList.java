class LinkedNode{
    public int data;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}
public class LinkedList {
    private LinkedNode head = null;

    public void display() {  //打印链表
        System.out.print("[");
        for (LinkedNode cur = head; cur != null; cur = cur.next) {
            if (cur.next == null) {
                System.out.print(cur.data);
            } else {
                System.out.print(cur.data + ",");
            }
        }
        System.out.println("]");
    }

    public void addFirst(int elem) {  //头插法
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {  //空链表清况
            this.head = node;
            return;
        }
        //不是空链表清况
        node.next = head;
        this.head = node;
    }

    public void addLast(int elem) {   //尾插法
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {
            head = node;
            return;
        }
        LinkedNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int elem) {
        int len = size();
        if (index < 0 || index > len) {
            return false;
        }
        if (index == 0) { //插头部
            addFirst(elem);
            return true;
        }
        if (index == len) { //插尾部
            addLast(elem);
            return true;
        }
        //插任意位置 重要的是肯定需要找到他前一个位置
        LinkedNode node = new LinkedNode(elem);
        LinkedNode cur = this.head;
        int i = 0;
        while (i < index - 1) {
            cur = cur.next;
            i++;
        }
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        if (this.head == null) {  //空链表
            return false;
        }
        LinkedNode cur = this.head;   //不是空链表进行遍历
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        if (this.head != null && this.head.data == key) {
            this.head = head.next;
            return;
        }
        LinkedNode cur = this.head;   //遍历找到那一个结点如果有这个结点则去把他前一个结点表示出来
        while (cur != null) {
            if(cur.next == null){      //防止越界 上面的cur.next.data越界
                break;
            }
            if (cur.next.data == key) {
                cur.next = cur.next.next;
                System.out.println("删除成功");
                return;
            }
            cur = cur.next;
        }
        System.out.println("无这个结点");
        return;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        while (this.head != null && this.head.data == key) { //删头结点 在其中利用短路与解决一个异常。
            this.head = head.next;
        }
        LinkedNode cur = this.head;
        while (cur != null) {         //遍历找到那一个结点如果有这个结点则去把他前一个结点表示出来
            if (cur.next == null) {      //防止越界 上面的cur.next.data越界
                break;
            }
            if (cur.next.data == key) {
                cur.next = cur.next.next;
            } else {                    //防止出现连续数 则cur不往后遍历还在原地继续删除后面的数
                cur = cur.next;
            }
        }
}
    //得到单链表的长度
    public int size() {
        int size = 0;
        LinkedNode cur = this.head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    //清空链表
    public void clear(){
        this.head = null;
    }
    public static void main(String[] args) {
        LinkedList  headlist = new LinkedList();

        headlist.addLast(1);
        headlist.addLast(1);
        headlist.addLast(2);
        headlist.addLast(1);
        headlist.addLast(1);
        headlist.display();
        headlist.removeAllKey(1);
        headlist.display();
    }
}
