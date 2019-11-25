package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    char val;
    Node left = null;
    Node right = null;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

public class MyTree {
     private static Node root = null;
    public static Node build(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return  A;
    }
    public static void preOrderTraversal(Node root){  //先序遍历
        if(root == null){
            return;
        }
        System.out.println(root );
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){   //中序遍历
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root );
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){ //后序遍历
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root );
    }
    public static int getSize1(Node root){   //算结点数
        if(root == null){
            return 0;
        }
        return 1 + getSize1(root.left) + getSize1(root.right);
    }

    private static int size = 0;
    public static void getsize2(Node root){  //算结点数
        if(root == null){
            return;
        }
        size++;
        getsize2(root.left);
        getsize2(root.right);
    }


    public static int getLeafSize1(Node root){   //算叶子结点数
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize1(root.left) + getLeafSize1(root.right);
    }

    private static int leafSize = 0;
    public static void getLeafSize2(Node root) {  //算叶子结点数
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize2(root.left);
        getLeafSize2(root.right);
    }
    public static int getKLevelSize(Node root, int k){ //求第K层结点数
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            // k 为 1 的时候, 就一个根节点
            return 1;
        }
        // 求第 k 层节点的个数,
        // 求左子树的第 k - 1 层节点的个数 + 右子树的 k - 1 层
        return getKLevelSize(root.left, k - 1)
                + getKLevelSize(root.right, k - 1);
   }


    // 还是递归. 先比较一下当前的根节点是不是要找的元素.
    // 递归找左子树和递归找右子树
    public static Node find(Node root, char toFind) {
        if (root == null) {
            return null;
        }
        // 当前节点是不是要找的节点
        if (root.val == toFind) {
            return root;
        }
        // 递归找左子树
        Node ret = find(root.left, toFind);
        if (ret != null) {
            return ret;
        }
        return find(root.right, toFind);
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        //创建一个队列，来做出入队列操作
        Queue<Node> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            //2.出队列，则把他的左子树与右子树入栈
            Node cur = stack.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                stack.offer(cur.left);
            }
            if(cur.right != null){
                stack.offer(cur.right);
            }
        }
    }

    public static boolean isCompleteTree(Node root){
        if(root == null){
            return true;
        }
        //1.还和上面层次一样,先建立队列，进行出入栈。
        Queue<Node> queue = new LinkedList<>();
        //设置一个初始boolean来标致到第几阶段了。
        boolean noChild = false;
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(!noChild){
                //左右子树全有就正常操作
                if(cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                //只有左子树，则开始第二阶段表示后面结点无子树
                if(cur.left != null && cur.right == null){
                    queue.offer(cur.left);
                    noChild = true;
                }
                //只有右子树,则一定是非完全二叉树
                if(cur.left == null && cur.right != null){
                    return false;
                }
                //左右子树均空，开启第二阶段后面结点无子树
                if(cur.left == null && cur.right == null){
                    noChild = true;
                }
            }
            else{
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Node root = build();
//        preOrderTraversal(root);
//        preOrderTraversal(root);
//        postOrderTraversal(root);
//        System.out.println(getSize1(root));
//        getsize2(root);
//        System.out.println(size);
//        System.out.println(getLeafSize1(root));
//        getLeafSize2(root);
//        System.out.println(leafSize);
//        System.out.println(find(root, 'F'));
        levelOrderTraversal(root);
        System.out.println(isCompleteTree(root));
    }
}
