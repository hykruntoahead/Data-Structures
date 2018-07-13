package com.company.leedcode_347;

import java.util.*;

public class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Freq1> pq = new PriorityQueue<>(
                new Comparator<Freq1>() {
                    @Override
                    public int compare(Freq1 a, Freq1 b) {
                        return a.freq - b.freq;
                    }
                }
        );
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq1(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq1(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }

        return res;

    }

    private class Freq1 {
        int e, freq;

        public Freq1(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            } else if (this.freq > another.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
