package NKTest;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NReserve {
    static class ListNode{
        int val;
        ListNode next = null;
        ListNode prev = null;
        public ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] num1 = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] num2 = br.readLine().split(" ");
        ListNode Lhead = creatL(n, num1);
        Lhead = reserve(Lhead);
        print(Lhead);
        System.out.println();
        ListNode DLhead = creatDL(m, num2);
        DLhead = reverseDoubleList(DLhead);
        print(DLhead);
    }
    public static ListNode creatL(int len, String[] arr){
        ListNode head = new ListNode(Integer.parseInt(arr[0]));
        ListNode cur = head;
        for(int i = 1; i < len; i++){
            cur.next = new ListNode(Integer.parseInt(arr[i]));
            cur = cur.next;
        }
        return head;
    }
    public static ListNode creatDL(int len, String[] arr){
        ListNode head = new ListNode(Integer.parseInt(arr[0]));
        ListNode cur = head;
        for(int i = 1; i < len; i++){
            ListNode tem = new ListNode(Integer.parseInt(arr[i]));
            cur.next = tem;
            tem.prev = cur;
            cur = tem;
        }
        return head;
    }
    public static ListNode reserve(ListNode head){
        if(head == null && head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode NewStart = null;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                NewStart = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return NewStart;
    }
    public static ListNode reverseDoubleList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, next = null;
        ListNode  curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void print(ListNode head){
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
