// 1171. Remove Zero Sum Consecutive Nodes from Linked List


// O(n^2) time complexity.
// public class Ques12 {

//     public ListNode removeZeroSumSublists(ListNode head) {
//         ListNode curr = head, prev = null;

//         while(curr != null) {
//             ListNode temp2 = curr;
//             int sum = 0;
//             while(temp2 != null) {
//                 sum += temp2.val;
//                 if(sum == 0) break;
//                 temp2 = temp2.next;
//             }
//             if(sum == 0) {
//                 if(prev == null) {
//                     curr = head = temp2.next;
//                 }
//                 else {
//                     prev.next = temp2.next;
//                     curr = temp2.next;
//                     temp2.next = null;
//                 }
//             }
//             else {
//                 prev = curr;
//                 curr = curr.next;
//             }
//         }

//         return head;
//     }
// }


// Approach 2: Prefix Sum Hash Table - (Optimized solution)


import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
}

class Solution {
    public void sanitizeMap(HashMap<Integer, ListNode> hmap, ListNode start, ListNode end, int pfSum) {
        while(start != end) {
            pfSum += start.val;
            hmap.remove(pfSum);
            start = start.next;
        }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> hmap = new HashMap<>();

        int pfSum = 0;
        ListNode temp = head;
        while(temp != null) {
            pfSum += temp.val;
            if(pfSum == 0) {
                head = temp.next;
                hmap.clear();
            }
            else if(hmap.containsKey(pfSum)) {
                ListNode temp2 = hmap.get(pfSum);
                sanitizeMap(hmap, temp2.next, temp, pfSum);
                temp2.next = temp.next;
            }
            else {
                hmap.put(pfSum, temp);
            }
            temp = temp.next;
        }

        return head;
    }
}