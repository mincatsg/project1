package package1104;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeDemo {
    // 内部类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 访问根节点. 此处我们的访问指的是把当前节点的值
        // 插入到 result 中
        result.add(root.val);
        // 递归遍历左子树
        result.addAll(preorderTraversal(root.left));
        // 递归遍历右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 递归访问左子树
        result.addAll(inorderTraversal(root.left));
        // 访问当前节点
        result.add(root.val);
        // 递归访问右子树
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 递归访问左子树
        result.addAll(postorderTraversal(root.left));
        // 递归访问右子树
        result.addAll(postorderTraversal(root.right));
        // 访问当前节点
        result.add(root.val);
        return result;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 本质上还是借助递归的思想拆分问题.
        // 判定两个树相同 => 比较根节点是否相同 + 比较左子树是否相同 + 比较右子树是否相同
        // 1. 如果两棵树都是空树, 这种直接返回 true
        if (p == null && q == null) {
            return true;
        }
        // 2. 如果两棵树一个为空一个不为空, 直接返回 false
        if (p == null || q == null) {
            return false;
        }
        // 3. 如果都不为空树
        //  a) 比较一下根节点的值是否相同. 如果不相同, 就直接返回 false
        if (p.val != q.val) {
            return false;
        }
        //  b) 递归比较左子树和递归比较右子树看看是不是也相同.
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 还是对问题进行递归的拆解.
        // 比较 s 是否包含 t => s 和 t 是不是相等 + s.left 是不是包含 t + s.right 是不是包含 t
        // 1. 如果两个树都是空树, 直接是 true
        if (s == null && t == null) {
            return true;
        }
        // 2. 如果两个树一个是空, 一个不是空, 暂且算作不包含. false
        if (s == null || t == null) {
            return false;
        }
        // 3. 如果两个数都非空
        //  a) 比较根节点的值是不是相等, 如果相等的话,
        //     比较一下 s 和 t 是不是相同的树, 如果是相同的树 就认为是包含的.
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        //  b) 递归的判定一下, t 是否被 s 的左子树包含
        if (!ret) {
            ret = isSubtree(s.left, t);
        }
        //  c) 递归的判定一下, t 是否被 s 的右子树包含
        if (!ret) {
            ret = isSubtree(s.right, t);
        }
        return ret;
    }

    public int maxDepth(TreeNode root) {
        // 借助递归把问题进行拆分
        // root 的深度 => 1 + 左子树的深度 和 右子树的深度 的最大值
        // 1. 如果是空树, 深度就是 0
        if (root == null) {
            return 0;
        }
        // 2. 如果只有一个根节点, 没有左右子树, 深度就是 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 3. 1 + max(左子树的深度, 右子树的深度)
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        // 1. 如果是空树, 就算平衡
        if (root == null) {
            return true;
        }
        // 2. 如果没有子树, 也算平衡
        if (root.left == null && root.right == null) {
            return true;
        }
        // 3. 求一下左右子树的高度, 判断一下差值是否 <= 1
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return false;
        }
        // 4. 递归判定左子树和右子树是不是也是平衡的.
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isSymmetry(TreeNode root) {
        // 把判断对称转换成判定 左右子树是否是镜像关系
        // 1. root 是空树
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // 1. 如果两个树都是空树, 应算镜像
        if (t1 == null && t2 == null) {
            return true;
        }
        // 2. 如果两个树一个空一个非空, 就不算镜像
        if (t1 == null || t2 == null) {
            return false;
        }
        // 3. 如果两个树都不为空
        //  a) 比较根节点是不是相同, 不相同就不是镜像
        if (t1.val != t2.val) {
            return false;
        }
        //  b) 递归比较子树, t1.left 和 t2.right ,
        //     t1.right 和 t2.left 是不是镜像
        return isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    public TreeNode MakeMirror(TreeNode root) {
        // 遍历 + 交换左右子树
        if (root == null) {
            return null;
        }
        // 交换就是此处的 "访问" 操作
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        MakeMirror(root.left);
        MakeMirror(root.right);
        return root;
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 创建一个队列辅助进行遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 1. 先把 root 插入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 2. 循环取队首元素. 访问这个元素.
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            // 3. 把当前这个队首元素左子树和右子树都插入队列中.
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public static TreeNode build() {
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

    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 1. 先对树进行层序遍历
        // 如果这个标记为 false, 说明还是处在第一阶段
        // 如果这个标记为 true , 接下来的节点就不能有子树
        // 也就是第二阶段开始了
        boolean needNoChild = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 对这个元素的情况进行判定了.
            // 访问是一组比较复杂的判断
            if (!needNoChild) {
                // 第一阶段的情况
                if (cur.left != null && cur.right != null) {
                    // 合格的状态, 继续往下遍历.
                    // 就把左右子树加入队列就行了
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 这种情况铁定不是完全二叉树
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 这是临界状态, 开启第二阶段
                    queue.offer(cur.left);
                    needNoChild = true;
                } else {
                    // 左右子树都为空, 开启第二阶段
                    needNoChild = true;
                }
            } else {
                // 第二阶段的情况
                // 第二阶段要求节点必须没有子树. 只要子树存在, 就不是完全二叉树
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }  // end if
        }  // end while
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        BinaryTreeDemo demo = new BinaryTreeDemo();
        demo.levelOrder(root);
    }
}
