// Delete N nodes from M nodes

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
    public void addAtHead(int value) {
        Node newnode = new Node(value);

        if(head == null) {
            head = newnode;
        }
        else {
            newnode.next = head;
            head = newnode;
        }
    }
    public void deleteAtTail() {
        if(head == null) {
            System.out.println("Can't delete the empty list!!");
        }
        else {
            Node temp = head, prev = null;
            while(temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            if(prev == null) {
                head = null;
            }
            else {
                prev.next = temp.next;
                temp.next = null;
            }
        }
    }
    public void deleteAtHead() {
        if(head == null) {
            System.out.println("Can't delete the empty list!!");
        }
        else {
            head = head.next;
        }
    }
    public void printList() {
        Node temp = head;

        while(temp != null) {
            if(temp.next != null) System.out.print(temp.val + "->");
            else System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    public void deleteNAFterMNodes(CustomLinkedList list, int n, int m) {
        Node temp = head;
        
        while(temp != null) {
            int x = m-1, y = n;
            while(temp != null && x != 0) {
                temp = temp.next;
                x--;
            }
            if(temp == null) break;
            Node temp2 = temp.next;
            while(temp2 != null && y != 0) {
                temp2 = temp2.next;
                y--;
            }
            if(temp2 == null) {
                temp.next = null;
                break;
            }
            temp.next = temp2;
            temp = temp2;
        }
    }
    public Node findMidNode() {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

public class Ques1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int m = 1, n = 3;
        // int m = 3, n = 1;

        // int[] arr = {9,3,7,7,9,10,8,2};
        // int m = 1, n = 2;

        CustomLinkedList lls = new CustomLinkedList();
        for(int i = 0; i < arr.length; i++) {
            lls.addAtTail(arr[i]);
        }
        
        lls.printList();
        lls.deleteNAFterMNodes(lls, n, m);
        lls.printList();    
        
        Node midNode = lls.findMidNode();
        if(midNode != null) System.out.println("mid node val: " + midNode.val);
        else System.out.println("list is empty!!");
        
    }
}