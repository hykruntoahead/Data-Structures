package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String filename = "E:\\github\\Data-Structure\\Set\\src\\com\\company\\17220.txt";
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BSTMap:" + time1 + "s\r\n");

        LinkedListMap linkedListMap = new LinkedListMap();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("LinkedListMap:" + time2 + "s\r\n");
    }

    private static double testMap(Map<String,Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println("THE CATCHER IN THE RYE");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation
                .readFile("E:\\github\\Data-Structure\\Map\\src\\17220.txt",
                        words)) {
            System.out.println("Total words:" + words.size());

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words:" + map.getSize());
            System.out.println("like count:" + map.get("like"));
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
