class Node {
    int data;
    Node next;
    Node bottom;
}

public class Ques6 {
    Node Merge(Node first, Node second) {
        if(first == null) return second;
        else if(second == null) return first;
        
        Node curr = null;
        Node temp1 = first, temp2 = second;
        while(temp1 != null && temp2 != null) {
            if(temp1.data <= temp2.data) {
                if(curr == null) curr = temp1;
                else {
                    curr.bottom = temp1;
                    curr = temp1;
                }
                temp1 = temp1.bottom;
            }
            else {
                if(curr == null) curr = temp2;
                else {
                    curr.bottom = temp2;
                    curr = temp2;
                }
                temp2 = temp2.bottom;
            }
        }
        
        while(temp1 != null) {
            if(curr == null) curr = temp1;
            else {
                curr.bottom = temp1;
                curr = temp1;
            }
            temp1 = temp1.bottom;
        }
        
        while(temp2 != null) {
            if(curr == null) curr = temp2;
            else {
                curr.bottom = temp2;
                curr = temp2;
            }
            temp2 = temp2.bottom;
        }
        
        if(first.data <= second.data) return first;
        return second;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root == null) return null;
        Node temp = root, newRoot = null, nextNode = null;
        
        while(temp != null) {
            Node second = temp.next;
            
            nextNode = temp.next;
            Node temp2 = Merge(temp, second);
            
            if(newRoot == null) newRoot = temp2;
            
            temp = nextNode;
        }
        
        return newRoot;
    }
    public static void main(String[] args) {
        
    }
}