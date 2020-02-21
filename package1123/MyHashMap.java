package package1123;

public class MyHashMap {
    public static class Node {
        public int key;
        public int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }

    private Node[] array = new Node[101];
    private int size = 0;
    private static final double FACTOR = 0.75;

    // 核心操作1: 插入元素 put
    public void put(int key, int value) {
        // 1. 根据 key 调用 hash 函数获取一个下标
        int index = key % array.length;
        // 2. 根据下标找到对应的链表
        Node head = array[index];
        // 3. 要判定一下当前 key 是否已经存在
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                // 如果这个 key 已经存在, 就不插入新节点
                // 而是直接修改旧节点的 value
                cur.value = value;
                return;
            }
        }
        // 4. 把新的节点插入到链表中
        //    头插更方便
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;

        // 5. 进行扩容的判定
        if ((double)size / array.length >= FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2 + 1];
        // 遍历原来hash表的每个元素, 然后把元素插入到新的 newArray 中
        for (int i = 0; i < array.length; i++) {
            // 取到每个链表, 再去遍历链表
            for (Node cur = array[i]; cur != null; cur = cur.next) {
                // 插入进去
                Node newNode = new Node(cur.key, cur.value);
                int index = cur.key % newArray.length;
                newNode.next = newArray[i];
                newArray[i] = newNode;
            }
        }
        array = newArray;
    }

    // 核心操作2: 查找元素 get
    public Node get(int key) {
        // 1. 先根据 key 计算下标
        int index = key % array.length;
        // 2. 再根据下标找到对应链表的头结点
        Node head = array[index];
        // 3. 在链表上遍历找到对应的 key
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur;
            }
        }
        return null;
    }
    // 核心操作3: 删除元素 remove
    public void remove(int key) {
        // 1. 根据 key 找到下标
        int index = key % array.length;
        // 2. 根据下标找到对应的链表
        Node head = array[index];
        // 3. 在链表上查找到对应的 key 并进行删除即可
        //  a) 要删除节点如果是头结点
        if (head.key == key) {
            array[index] = head.next;
            return;
        }
        //  b) 要删除节点不是头结点, 找到该结点的前一个节点
        Node prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.key == key) {
                // 这就找到了当前元素的前一个元素
                prev.next = prev.next.next;
                size--;
                break;
            }
        }
    }
}
