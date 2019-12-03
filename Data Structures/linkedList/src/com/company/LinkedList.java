package com.company;

public class LinkedList {
    Node head = null;
    public void add(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
        return;
    }

    public void printList(){
        Node current = head;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

}
