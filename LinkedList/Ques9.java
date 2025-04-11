// Merge nodes in between zeros.

class ListNode {
    int val;
    ListNode next;
}

public class Ques9 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        int count = 0;

        ListNode firstList = head, secondList = head.next;
        ListNode secondListHeadTemp = secondList;

        while(firstList.next != null && secondList.next != null) {
            if((count & 1) == 1) {
                secondList.next = firstList.next;
                secondList = secondList.next;
            }
            else {
                firstList.next = secondList.next;
                firstList = firstList.next;
            }
            count++;
        }
        if(firstList.next == null) secondList.next = null;
        firstList.next = secondListHeadTemp;

        return head;
    }
}
