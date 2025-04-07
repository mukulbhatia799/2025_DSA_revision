// 19. Remove Nth Node From End of List


class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class CustomLinkedList {
    Node head;
    public Node getHead() {
        return head;
    }
    public void addAtTail(int value) {
        Node newnode = new Node(value);

        if(head == null) {
            head = newnode;
        }
        else {
            Node temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newnode;
        }
    }
    public void printList(Node head) {
        Node temp = head;

        while(temp != null) {
            if(temp.next != null) System.out.print(temp.val + "->");
            else System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    public Node removeRec(int[] n, Node prev, Node curr) {
        if(curr == null) return head;

        removeRec(n, curr, curr.next);
        n[0]--;
        if(n[0] == 0) {
            if(curr == head) head = head.next;
            if(prev != null) prev.next = curr.next;
            curr.next = null;
        }
        return head;
    }
    public Node removeNthFromEnd(int n) {
        int[] del = {n};
        head = removeRec(del, null, head);

        return head;
    }
}

public class Ques3 {
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};
        // int n = 2;
        // int[] arr = {1};
        // int n = 1;
        int[] arr = {1,2};
        int n = 1;
        
        CustomLinkedList lls = new CustomLinkedList();
        for(int i = 0; i < arr.length; i++) {
            lls.addAtTail(arr[i]);
        }

        lls.printList(lls.getHead());

        Node newhead = lls.removeNthFromEnd(n);
        System.out.print("New List: ");
        lls.printList(newhead);
        
    }
}
