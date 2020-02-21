package package1123;

public class BinarySearchTree {
    public static class Node {
        public int key;
        public int value;
        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    // 创建一个根节点, 初始情况下是空树, 根节点指向 null
    private Node root = null;

    // 查找
    public Node search(int key) {
        // 从 root 出发, 比较 key 和 root 中 key 的大小关系
        // 根据这个关系来决定接下来在左子树中找, 还是右子树中找
        // 如果遇到 null 说明查找完毕了
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                // 找到了!
                return cur;
            } else if (key < cur.key) {
                // 去左子树找
                cur = cur.left;
            } else {
                // 去右子树找
                cur = cur.right;
            }
        }
        // 没找到
        return null;
    }

    // 插入
    // 1. 先找到合适位置
    // 2. 把新的节点放到合适的位置就行了
    // 啥时候会插入失败呢?
    // 约定方式一:
    // 如果当前的 key 在树中已经存在了, 认为插入失败
    // 约定方式二:
    // 如果当前的 key 存在, 直接修改 value
    public boolean insert(int key, int value) {
        // 1. 如果当前要插入的树是空树的话, 直接让 root
        //    指向新节点即可
        if (root == null) {
            root = new Node(key, value);
            return true;
        }
        // 2. 对于一个不是空的树, 需要先找到合适的位置
        //    查找的过程中, 随时要记录当前节点的父亲
        Node cur = root;
        // 让 parent 一直要指向 cur 的父节点
        Node parent = null;
        while (cur != null) {
            if (key == cur.key) {
                // 已经存在了
                return false;
            } else if (key < cur.key) {
                // 在左子树中找
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        // 循环结束的时候, cur 一定是 null
        // 新节点就应该插入到 parent 下方
        // 上面的循环, 关键点在于要确定 parent 是谁
        Node newNode = new Node(key, value);
        if (key < parent.key) {
            // 应该插入到左子树位置
            parent.left = newNode;
        } else {
            // 插入到右子树的位置
            parent.right = newNode;
        }
        return true;
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        // 查找要删除的元素的位置
        while (cur != null) {
            if (key == cur.key) {
                // 找到了!
                removeNode(parent, cur);
                return true;
            } else if (key < cur.key) {
                // 向左找
                parent = cur;
                cur = cur.left;
            } else {
                // 向右找
                parent = cur;
                cur = cur.right;
            }
        }
        // 树中没有找到对应的节点
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            // 1. 没有左子树的情况
            if (cur == root) {
                // 1.1 直接让 root 指向 cur.right
                root = cur.right;
            } else if (cur == parent.left) {
                // 1.2 让 parent 的 left 指向 cur 的 right
                parent.left = cur.right;
            } else {
                // 1.3 让 parent 的 right 指向 cur 的 right
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            // 2. 没有右子树的情况
            if (cur == root) {
                // 2.1 直接让 root 指向 cur.left
                root = cur.left;
            } else if (cur == parent.left) {
                // 2.2 让 parent 的 left 指向 cur 的 left
                parent.left = cur.left;
            } else {
                // 2.3 让 parent 的 right 指向 cur 的 left
                parent.right = cur.left;
            }
        } else {
            // 3. 同时有左右子树的情况
            Node scapeGoat = cur.right;
            Node goatParent = cur;
            //  a) 要去待删除节点的右子树中去找最左侧元素, 替罪羊
            while (scapeGoat.left != null) {
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            // 循环结束的时候, scapeGoat 就是替罪羊节点.
            //  b) 把替罪羊的 key value 赋值到待删除节点中
            cur.key = scapeGoat.key;
            cur.value = scapeGoat.value;
            //  c) 再删除替罪羊节点(删除替罪羊节点的过程就和上面讨论的过程是一样的)
            //     替罪羊一定没有左子树, 还需要根据替罪羊是
            //     父节点的左还是右还得进一步判定如何删除
            if (scapeGoat == goatParent.left) {
                // 替罪羊节点是父亲的左子树
                goatParent.left = scapeGoat.right;
            } else {
                // 当前替罪羊节点正好就是 cur.right 的时候
                // 就满足这个分支的情况
                goatParent.right = scapeGoat.right;
            }
        }
    }

    public static void main(String[] args) {
        // 建立一个二叉搜索树
        BinarySearchTree tree = new BinarySearchTree();

        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        for (int x : arr) {
            tree.insert(x, 0);
        }
        System.out.println(tree.search(3));
        tree.remove(5);
        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }
}
