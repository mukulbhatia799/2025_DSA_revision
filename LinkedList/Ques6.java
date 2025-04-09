// flattening linked list

class Node {
    int data;
    Node next;
    Node bottom;
}

public class Ques6 {
    public static Node Merge(Node first, Node second) {
        if(first == null) return second;
        if(second == null) return first;

        Node newHead = null;
        if(first.data <= second.data) {
            newHead = first;
            first.bottom = Merge(first.bottom, second);
        }
        else {
            newHead = second;
            second.bottom = Merge(first, second.bottom);
        }

        return newHead;
    }
    // Function to flatten a linked list
    Node flatten(Node head) {
        if(head == null) return null;

        Node mergedLLHead = Merge(head, flatten(head.next));

        return mergedLLHead;
    }
    public static void main(String[] args) {
        
    }
}