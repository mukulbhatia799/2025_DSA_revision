class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Ques5 {
    public ListNode Merge(ListNode leftHead, ListNode rightHead) {
        ListNode curr = null;

        ListNode temp1 = leftHead, temp2 = rightHead;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                if(curr != null) curr.next = temp1;
                curr = temp1;
                temp1 = temp1.next;
            }
            else {
                if(curr != null) curr.next = temp2;
                curr = temp2;
                temp2 = temp2.next;
            }
        }

        while(temp1 != null) {
            if(curr != null) curr.next = temp1;
            curr = temp1;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            if(curr != null) curr.next = temp2;
            curr = temp2;
            temp2 = temp2.next;
        }

        if(leftHead == null) return rightHead;
        else if(rightHead == null) return leftHead;
        else if(leftHead.val <= rightHead.val) return leftHead;
        return rightHead;
    }
    public ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // System.out.println("midNode: " + slow.val);
        return slow;
    }
    // public void printList(ListNode head) {
    //     System.out.print("list: ");
    //     ListNode temp = head;
    //     while(temp != null) {
    //         System.out.print(temp.val + " ");
    //         temp = temp.next;
    //     }
    //     System.out.println();
    // }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode midNode = findMidNode(head);
        ListNode leftHead = head;
        ListNode rightHead = midNode.next;
        midNode.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        // System.out.println("leftHead: " + leftHead.val + " rightHead: " + rightHead.val);
        ListNode mergedListHead = Merge(leftHead, rightHead);
        // printList(mergedListHead);
        return mergedListHead;
    }
    public static void main(String[] args) {
        
    }
}
