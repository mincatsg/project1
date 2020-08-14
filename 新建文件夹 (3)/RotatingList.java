package InterviewTraining2;

public class RotatingList {
//    旋转链表
//    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null){  //空链表或只有1个
        return head;
    }
    ListNode cur1 = head;
    int len = 0;
    while(cur1 != null){   //计算链表长度,
        cur1 = cur1.next;
        len++;
    }
    int i = 0;
    k = k % len;   //防止翻转数值过大，实际上就是k%上链表长度的值 实际上的遍历，其他就是重复而已.
    while(i < k){
        ListNode cur = head;
        while(cur.next.next != null){
            cur = cur.next;
        }
        ListNode tem = cur.next;   //存下要删除那一点
        cur.next = null;  //删除那一点
        ListNode node = new ListNode(tem.val);  //头插
        node.next = head;
        head = node;
        i++;
    }
    return head;
}
}
