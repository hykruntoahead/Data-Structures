package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,999);
        System.out.println(linkedList);
    }
}
