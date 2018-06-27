package com.company.leedcode_203;

///**LeedCode 203 删除链表中的节点

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        ListNode preNode = head;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                ListNode delNode = preNode.next;
                preNode.next = delNode.next;
                delNode.next = null;
            } else {
                preNode = preNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nodes);
        System.out.println(head);

        ListNode listNode = new Solution().removeElements(head, 6);
        System.out.println(listNode);
    }
}