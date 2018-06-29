package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String filename = "E:\\github\\Data-Structure\\Set\\src\\com\\company\\17220.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set:" + time1 + "s\r\n");

        LinkedListSet linkedListSet = new LinkedListSet();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedListSet Set:" + time2 + "s\r\n");
    }

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println("THE CATCHER IN THE RYE");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(filename, words1);
        System.out.println("Total words:" + words1.size());


        for (String word : words1) {
            set.add(word);
        }
        System.out.println("Total different words:" + set.getSize());
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
