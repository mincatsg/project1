package package1109;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeDemo {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        // 正常二叉树的层数是从 1 开始计算的.
        // 此处为了和下标对应方便, 就直接从 0 开始算
        helper(root, 0);
        return result;
    }

    // 辅助完成递归遍历的过程
    private void helper(TreeNode root, int level) {
        if (level == result.size()) {
            // 达到的第 level 层还没有对应的数组, 此时就需要
            // 创建一个新的数组加入到 result 中
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    private TreeNode lca = null;  // 保存最终的公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 借助一个辅助函数, 在 root 中递归查找 p 和 q.
        //    设定辅助函数的返回值, 如果找到返回 1(找到一个或者两个都算), 没找到 返回 0
        // 2. 这个递归查找的过程进一步拆解开. 递归在左子树中查找 + 递归在右子树中查找 + 对比根节点
        // 3. 如果这三个位置中, 有两个地方找到了, 这个当前节点就是要找的最近公共祖先
        if (root == null) {
            return null;
        }
        // 辅助函数
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 递归在左子树中尝试找 p 或者 q
        int left = findNode(root.left, p, q) ? 1 : 0;
        // 递归在右子树中尝试查找 p 或者 q
        int right = findNode(root.right, p, q) ? 1 : 0;
        // 对比一下当前节点有没有找到
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            // 找到 lca, 就是当前的 root
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        // 使用中序遍历, 就能够得到有序序列.
        // 把相邻元素相互指向就行了. left 指向前一个元素, right 指向后一个元素
        // 1. 判定特殊情况, 如果是空树, 或者只有一个节点.
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        // 2. 递归把左子树变成双向链表, 并返回这个链表的第一个节点
        TreeNode left = Convert(pRootOfTree.left);
        // 3. 如果左侧链表头结点不为 null, 当前左侧链表的尾巴找到,
        //    让左侧链表的尾节点和当前 root 节点相互指向.
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 循环结束之后, leftTail 就指向了左侧链表的最后一个节点.
        // 要时刻注意, left 可能是 null
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 4. 递归讲右子树也构造成双向链表, 同时也得到右子树链表的第一个节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5. 把右侧链表的头结点和当前节点相互指向
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        // 6. 返回整个链表的头结点
        return left == null ? pRootOfTree : left;
    }

    // 表示先序遍历数组中, 访问到第几个字符了
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 每次构建之前要置为 0, 因为在线 OJ 有多组测试
        index = 0;
        // 在这个递归过程中, 需要处理到某个具体的子树.
        // [0, inorder.length) 当前处理的子树对应的中序遍历结果是什么
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int inorderLeft, int inorderRight) {
        // 先判定非法情况
        if (inorderLeft >= inorderRight) {
            // 这个子树的中序遍历是没有的. 这就是个空子树
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        // 取出当前值构造当前子树的根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;  // 取完这个节点, 就可以取下一个节点了
        // 需要找到这个节点在中序遍历中的位置.
        // pos 只要说 先序遍历 和 中序遍历 序列都是对的.
        // pos 是一定能找到的.
        int pos = find(inorder, inorderLeft, inorderRight, root.val);
        root.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1 , inorderRight);
        return root;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    // 用来保存最终的字符串结果
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        tree2strHelper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void tree2strHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        // 借助这个方法来完成递归的规程
        // 按照先序遍历的方式来递归
        stringBuilder.append("(");
        // 访问当前节点
        stringBuilder.append(root.val);
        // 访问左子树
        tree2strHelper(root.left);
        // 如果左子树为空, 并且右子树非空, 需要 () 占位
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        // 访问右子树
        tree2strHelper(root.right);
        stringBuilder.append(")");
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 先创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 把根节点入栈
        stack.push(root);
        // 3. 循环取栈顶元素, 访问之
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            // 4. 把当前元素的右子树和左子树分别入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 创建一个 cur 变量从 root 出发
        TreeNode cur = root;
        while (true) {
            // 3. 只要 cur 遇到的节点非 null, 就入栈, cur = cur.left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 4. 当 cur 遇到 null 的, 就出栈一个元素, 访问这个元素
            if (stack.isEmpty()) {
                // 遍历结束了
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            // 5. cur 指向当前元素的右子树
            cur = top.right;
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 创建一个 cur 从 root 出发
        TreeNode cur = root;
        // prev 永远指向上次访问的节点
        TreeNode prev = null;
        while (true) {
            // 3. 借助 cur 循环往左找, 如果该节点不为 null, 入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 4. 如果 cur 为 null, 取栈顶元素, 准备访问.
            //    要是 top 能访问, 再 pop, 否则还得在栈里待一会
            if (stack.isEmpty()) {
                // 遍历结束
                break;
            }
            TreeNode top = stack.peek();
            // 5. 到底能不能访问栈顶元素, 有两种情况:
            //  a) 栈顶元素没有右子树, 就可以访问
            //  b) 栈顶元素的右子树刚刚已经访问过, 也可以访问
            if (top.right == null || prev == top.right) {
                // 这种情况说明可以访问 top 节点
                System.out.print(top.val);
                stack.pop();
                // 同时要更新 prev
                prev = top;
            } else {
                // 此时这个节点还不能访问
                // 6. cur 指向 栈顶元素的 右子树,
                cur = top.right;
            }
        }
    }

    public static TreeNode buildTree() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        postOrder(root);
        System.out.println();
    }
}

