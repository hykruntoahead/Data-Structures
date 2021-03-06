package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(
                nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
//        System.out.println("segmentTree = " + segmentTree);

        System.out.println(segmentTree.query(0,2));
        System.out.println(segmentTree.query(3,5));
    }
}
