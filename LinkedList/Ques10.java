// 2816. Double a Number Represented as a Linked List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Ques10 {
    void findAns(ListNode head, int[] carry) {
        if(head == null) return ;

        findAns(head.next, carry);

        int sum = head.val * 2;
        head.val = (sum % 10) + carry[0];
        carry[0] = sum / 10;
    }
    public ListNode doubleIt(ListNode head) {
        int[] carry = new int[1];

        findAns(head, carry);
        if(carry[0] != 0) {
            ListNode temp = new ListNode(carry[0]);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
