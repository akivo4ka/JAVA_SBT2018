package linkedlist;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(3);
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 2);
        myLinkedList.add(5);
        myLinkedList.add(myLinkedList.size - 1, 4);
        System.out.println("First myLinkedList (Integer):");
        System.out.println(myLinkedList);

        System.out.println("Get first element: " + myLinkedList.get(0));
        System.out.println("Removed first element: " + myLinkedList.remove(0));
        myLinkedList.add(0, 1);

        MyLinkedList<Number> myLinkedList2 = new MyLinkedList<>();
        myLinkedList2.addAll(myLinkedList);
        myLinkedList2.add(1.0);
        myLinkedList2.add(3, 123L);
        myLinkedList2.add(myLinkedList2.size - 1, -7.54f);
        System.out.println("\nSecond myLinkedList (Number):");
        System.out.println(myLinkedList2);

        MyLinkedList<Object> myLinkedList3 = new MyLinkedList<>();
        myLinkedList3.copy(myLinkedList2);
        myLinkedList3.remove(0);
        myLinkedList3.remove(myLinkedList3.size - 1);
        myLinkedList3.add(myLinkedList3.size / 2, null);
        System.out.println("\nThird myLinkedList (Object):");
        System.out.println(myLinkedList3);
    }
}
