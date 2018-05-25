package com.epam.practice.practice.ds.linkedlist;

class Node {
    int data;
    Node next;

    public Node(){
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.next = next;
        this.data = data;
    }
}

public class SingleLinkedList {

    public static void display(Node head) {
        System.out.print("List: ");
        while (head.next != null) {
            System.out.print(" " + head.data);
            head = head.next;
        }
        System.out.println("");
    }

    public static Node insertFirst(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    public static Node delete(Node start, int data) {
        if (start == null) {
            return start;
        } else if (start.data == data) {
            return start.next;
        }

        for (Node p = start; p.next != null; p = p.next) {
            if (p.next.data == data) {
                p.next = p.next.next;
                break;
            }
        }
        return start;
    }

    public static Node insertIndex(Node start , int data, int pos){
        Node p=start;
        for (int i=0;i<pos;i++)
        {
            p=p.next;
        }
        Node temp = new Node(data);
         p.next=temp;
        //temp.next=p.next;
        return start;
    }

    public static void main(String[] args) {

        Node head = new Node();
        head = insertFirst(head, 4);
        display(head);
        head = insertFirst(head, 5);
        display(head);
        head = insertFirst(head, 7);
        head = insertFirst(head, 8);
        display(head);
       // head = delete(head, 3);
       // display(head);

        head = insertIndex(head,9,2);
        display(head);
    }

}
