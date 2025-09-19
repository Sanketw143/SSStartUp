package org.ssupstart.datastructure.linkedList;

public class LinkedListOne {

    public static Node head;

    class Node {
        public int val;
        public Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    public void insertNode(int val) {
        if(head == null) {
            head = new Node(null, val);
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(null, val);
        }
    }

    public static void main(String[] args) {
        LinkedListOne ll = new LinkedListOne();
        ll.insertNode(4);
        ll.insertNode(8);
        ll.insertNode(12);
        ll.insertNode(16);
        ll.insertNode(20);
        ll.printLinkedList();

//        removeNthNodeBF(1);
//        removeNthNodeOP(3);
        ll.printLinkedList();
    }

    private static void removeNthNodeOP(int n) {
        Node fastNode = head;
        Node slowNode = head;
        int count = 0;
        while(count<n) {
            fastNode = fastNode.next;
            count++;
        }
        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        System.out.println("slow : " + slowNode.val + "    " + "fastNode " + fastNode.val);
    }

    private static void removeNthNodeBF(int n) {
        int length =0;
        Node temp = head;
        if(temp == null) {
            System.out.println("LL is empty while removing node function");
        } else if(temp.next == null) {
            head = null;
            return;
        }
        while(null != temp) {
            length++;
            temp = temp.next;
        }
        temp = head;
        for(int i=1; i<length-n;i++) {
           temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    private void reverseLinkedList() {
        Node prev = null;
        Node temp = head;
        while(temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
    }

    private void printLinkedList() {
        Node temp = head;
        if(head == null) {
            System.out.println("LL is empty while printing linked list");
        }
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }
}
