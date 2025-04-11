// Rotate list K times.
public class Ques7 {
    public int llLength(ListNode head) {
        if(head == null) return 0;

        return 1 + llLength(head.next);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = llLength(head);
        k = k % len;
        if(k == 0) return head;
        int actualk = len-k-1;

        ListNode temp = head;
        for(int i = 1; i <= actualk; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        ListNode ptr = newHead;
        while(ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = head;

        return newHead;
    }
    public static void main(String[] args) {
        
    }
}
