// find min/max number between critical points (LC-2058)

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Ques8 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prevNode = head, currNode = head.next;
        int count = 2, firstCri = 0, prevCri = 0;
        int[] ans = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        while(currNode.next != null) {
            if((prevNode.val > currNode.val && currNode.next.val > currNode.val) || (prevNode.val < currNode.val && currNode.next.val < currNode.val)) {
                if(firstCri == 0) {
                    firstCri = prevCri = count;
                }
                else {
                    ans[0] = Math.min(ans[0], count-prevCri);
                    ans[1] = count-firstCri;
                    prevCri = count;
                }
            }
            count++;
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(ans[0] == Integer.MAX_VALUE) {
            ans[0] = ans[1] = -1;
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}