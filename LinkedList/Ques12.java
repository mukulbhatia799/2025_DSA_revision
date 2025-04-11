// 1171. Remove Zero Sum Consecutive Nodes from Linked List


// O(n^2) time complexity.
public class Ques12 {
    // public void print(ListNode head) {
    //     while(head != null) {
    //         System.out.print(head.val + " ");
    //         head = head.next;
    //     }
    //     System.out.println();
    // }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode curr = head, prev = null;

        while(curr != null) {
            ListNode temp2 = curr;
            int sum = 0;
            while(temp2 != null) {
                sum += temp2.val;
                if(sum == 0) break;
                temp2 = temp2.next;
            }
            if(sum == 0) {
                if(prev == null) {
                    curr = head = temp2.next;
                }
                else {
                    prev.next = temp2.next;
                    curr = temp2.next;
                    temp2.next = null;
                }
            }
            else {
                prev = curr;
                curr = curr.next;
            }
            // print(head);
        }

        return head;
    }
}
