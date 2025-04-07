


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
    public void printList(Node head) {
        Node temp = head;

        while(temp != null) {
            if(temp.next != null) System.out.print(temp.val + "->");
            else System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    
    public Node mergeTwoLists(Node list1, Node list2) {
        Node curr = null;
        Node temp1 = list1, temp2 = list2;

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

        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        else if(list1.val <= list2.val) return list1;
        return list2;
    }
}



public class Ques2 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};

        Node list1 = null, list2 = null;
        if(arr1.length != 0) list1 = new Node(arr1[0]);
        if(arr2.length != 0) list2 = new Node(arr2[0]);
        Node temp1 = list1, temp2 = list2;
        for(int i = 1; i <  arr1.length; i++) {
            Node newnode = new Node(arr1[i]);
            temp1.next = newnode;
            temp1 = newnode;
        }
        for(int i = 1; i <  arr2.length; i++) {
            Node newnode = new Node(arr2[i]);
            temp2.next = newnode;
            temp2 = newnode;
        }

        CustomLinkedList lls = new CustomLinkedList();
        System.out.print("list1: ");
        lls.printList(list1);
        System.out.print("list2: ");
        lls.printList(list2);
        
        Node newnode = lls.mergeTwoLists(list1, list2);
        
        lls.printList(newnode);

    }
}