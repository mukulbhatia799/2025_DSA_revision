// Swapping nodes in a Linked list

class ListNode {
    int val;
    ListNode next;
}

public class Ques11 {
    int findLen(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int len = findLen(head);

        int ind2 = len-k, count = 0;
        ListNode temp = head, node1 = null, node2 = null;
        while(count != len) {
            
            if(count == k-1) node1 = temp;
            if(count == ind2) {
                node2 = temp;
            }
            temp = temp.next;
            count++;
        }

        int tempVal = node1.val;
        node1.val = node2.val;
        node2.val = tempVal;

        return head;
    }
}
