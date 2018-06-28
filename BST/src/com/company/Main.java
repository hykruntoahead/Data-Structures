package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
            /////////////////////
            //        5        //
            //      /   \      //
            //     3     6     //
            //    / \     \    //
            //   2  4      8   //
            /////////////////////
        }

        System.out.println("----------层序遍历-----------");
        bst.levelOrder();

//        System.out.println("----------前序遍历-----------");
//        bst.preOrder();
//        System.out.println("----------非递归前序遍历-----------");
//        bst.preOrderNR();
//        System.out.println("----------中序遍历-----------");
//        bst.inOrder();
//        System.out.println("----------后序遍历----------");
//        bst.postOrder();
//        System.out.println(bst);
    }
}
