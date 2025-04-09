// flattening linked list

class Node {
    int data;
    Node next;
    Node bottom;
}

public class Ques6 {
    public static Node Merge(Node first, Node second) {
        if(first == null && second == null) return null;
        if(first == null) return second;
        if(second == null) return first;

        Node newHead = null;
        if(first.data <= second.data) {
            newHead = first;
            newHead.bottom = Merge(first.bottom, second);
        }
        else {
            newHead = second;
            newHead.bottom = Merge(first, second.bottom);
        }

        return newHead;        
    }
    // Function to flatten a linked list
    Node flatten(Node head) {
        if(head == null) return null;

        head.next = flatten(head.next);

        Node mergedLLHead = Merge(head, head.next);

        return mergedLLHead;
    }
    public static void main(String[] args) {
        
    }
}