package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        for (int i = 0; i < myLinkedList.size; ++i) {
            System.out.println(myLinkedList.get(i));
        }
        myLinkedList.add(1, 3);
        myLinkedList.add(0, 1);
        myLinkedList.add(5);
        for (Integer i:myLinkedList) {
            System.out.println(i);
        }
        System.out.println("Removed element: " + myLinkedList.remove(0));
        for (Integer i:myLinkedList) {
            System.out.println(i);
        }
        System.out.println(myLinkedList.remove(0));
        System.out.println(myLinkedList.remove(0));
        System.out.println(myLinkedList.remove(0));
    }
}
