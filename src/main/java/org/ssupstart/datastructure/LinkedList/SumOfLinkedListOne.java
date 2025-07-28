package org.ssupstart.datastructure.LinkedList;

public class SumOfLinkedListOne {
    static class Node {
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

        public Node() {
        }
        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node llOne = new Node(1);
        llOne.next = new Node(4);
        llOne.next.next = new Node(3);
        llOne.next.next.next = new Node(9);

        Node llTwo = new Node(2);
        llTwo.next = new Node(2);
        llTwo.next.next = new Node(2);

        Node sumHeadNode = getSumOfLinkedList(llOne, llTwo);
        printLinkedList(sumHeadNode);

        removeNthNode(llOne.next.next);
        printLinkedList(llOne);
    }

    private static void removeNthNode(Node node) {
        int val = node.next.val;
        node.val = val;
        node.next = node.next.next;
    }

    private static void printLinkedList(Node sumHeadNode) {
        Node temp = sumHeadNode;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }


    private static Node getSumOfLinkedList(Node llOne, Node llTwo) {
        Node dummy = new Node();
        Node temp = dummy;
        Integer carry = 0;

        while(llOne != null || llTwo != null || carry != 0) {
            int llOneNodeVal = llOne != null ? llOne.val : 0;
            int llTwoNodeVal = llTwo != null ? llTwo.val : 0;

            int totalSum = llOneNodeVal + llTwoNodeVal + carry;

            carry = totalSum/10;

            int currentDigit = totalSum%10;
            temp.next = new Node(currentDigit);
            temp = temp.next;

            if(llOne != null) {
                llOne = llOne.next;
            }
            if(llTwo != null) {
                llTwo = llTwo.next;
            }
        }
        return dummy.next;
    }
}
