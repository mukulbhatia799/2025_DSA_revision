// intersection of linked lists


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Ques4 {
    public int findLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode findAns(ListNode tempA, ListNode tempB, boolean[] check) {
        if(tempA == null) return null;

        ListNode ans = findAns(tempA.next, tempB.next, check);

        if(check[0] == true && tempA == tempB) return tempA;
        else check[0] = false;

        return ans;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = findLength(headA);
        int len2 = findLength(headB);

        ListNode tempA = headA, tempB = headB;
        if(len1 <= len2) {
            int diff = len2-len1;
            while(diff != 0) {
                tempB = tempB.next;
                diff--;
            }
        }
        else {
            int diff = len1-len2;
            while(diff != 0) {
                tempA = tempA.next;
                diff--;
            }
        }

        boolean[] check = new boolean[1];
        check[0] = true;
        return findAns(tempA, tempB, check);
    }
}