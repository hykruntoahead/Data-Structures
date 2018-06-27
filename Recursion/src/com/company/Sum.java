package com.company;

public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        //第一部分 求解最基本问题
        if (l == arr.length) {
            return 0;
        }
        //第二部分 把原问题转化为更小的问题
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(nums));
    }

}
