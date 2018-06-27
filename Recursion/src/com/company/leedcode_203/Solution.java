package com.company.leedcode_203;

import com.company.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nodes);
        System.out.println(head);

        ListNode listNode = new Solution().removeElements(head, 6);
        System.out.println(listNode);
    }
}
