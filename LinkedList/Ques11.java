// Swapping nodes in a Linked list - 1721

class ListNode {
    int val;
    ListNode next;
}

// public class Ques11 {
//     int findLen(ListNode head) {
//         int count = 0;
//         while(head != null) {
//             count++;
//             head = head.next;
//         }
//         return count;
//     }
//     public ListNode swapNodes(ListNode head, int k) {
//         int len = findLen(head);

//         int ind2 = len-k, count = 0;
//         ListNode temp = head, node1 = null, node2 = null;
//         while(count != len) {
            
//             if(count == k-1) node1 = temp;
//             if(count == ind2) {
//                 node2 = temp;
//             }
//             temp = temp.next;
//             count++;
//         }

//         int tempVal = node1.val;
//         node1.val = node2.val;
//         node2.val = tempVal;

//         return head;
//     }
// }


// instead of changing the values, change the links of the nodes.

public class Ques11 {
    int findLen(ListNode head) {
        if(head == null) return 0;

        return 1 + findLen(head.next);
    }
    // void print(ListNode head) {
    //     ListNode temp = head;
    //     while(temp != null) {
    //         System.out.println("temp.val: " + temp.val);
    //         temp = temp.next;
    //     }
    // }
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null) return head;
        int len = findLen(head);
        // System.out.println("len: " + len);

        int leftIndex = k;
        int rightIndex = len-k+1;

        if(leftIndex > rightIndex) {
            int temp = leftIndex;
            leftIndex = rightIndex;
            rightIndex = temp;
        }
        if(leftIndex == rightIndex) {
            return head;
        }
        else if(len == 2) {
            ListNode leftCurr = head, rightCurr = head.next;
            rightCurr.next = leftCurr;
            leftCurr.next = null;
            head = rightCurr;
        }
        else if(k == 1 || k == len) {
            ListNode leftCurr = head, rightPrev = null, rightCurr = head;
            while(rightCurr.next != null) {
                rightPrev = rightCurr;
                rightCurr = rightCurr.next;
            }
            rightCurr.next = leftCurr.next;
            rightPrev.next = leftCurr;
            leftCurr.next = null;
            head = rightCurr;
        }
        else if(rightIndex-leftIndex == 1) {
            ListNode leftPrev = null, leftCurr = head, rightCurr = head;
            while((leftIndex-1) != 0) {
                leftPrev = leftCurr;
                leftCurr = leftCurr.next;
                leftIndex--;
            }
            rightCurr = leftCurr.next;

            leftPrev.next = rightCurr;
            leftCurr.next = rightCurr.next;
            rightCurr.next = leftCurr;
        }
        else {
            ListNode leftPrev = null, leftCurr = head, rightPrev = null, rightCurr = head;

            while((leftIndex-1) != 0) {
                leftPrev = leftCurr;
                leftCurr = leftCurr.next;
                leftIndex--;
            }
            while((rightIndex-1) != 0) {
                rightPrev = rightCurr;
                rightCurr = rightCurr.next;
                rightIndex--;
            }

            // System.out.println("leftPrev: " + leftPrev.val);
            // System.out.println("leftCurr: " + leftCurr.val);
            // System.out.println("rightPrev: " + rightPrev.val);
            // System.out.println("righCurr: " + rightCurr.val);

            leftPrev.next = rightCurr;
            ListNode rightTemp = rightCurr.next;
            rightCurr.next = leftCurr.next;
            rightPrev.next = leftCurr;
            leftCurr.next = rightTemp;
        }

        // print(head);
        return head;
    }
    public static void main(String[] args) {

    }
}