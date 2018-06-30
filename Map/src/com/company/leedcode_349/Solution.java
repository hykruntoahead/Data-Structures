package com.company.leedcode_349;

/*
给定两个数组，写一个函数来计算它们的交集。

例子:

 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

提示:

    每个在结果中的元素必定是唯一的。
    我们可以不考虑输出结果的顺序。

 */

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
