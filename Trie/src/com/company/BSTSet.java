package com.company;

import java.util.ArrayList;

//基于二分搜索树的集合类  ---> 有序集合
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("E:\\github\\Data-Structure\\Set\\src\\com\\company\\17220.txt", words1);
        System.out.println("Total words:" + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words:" + set1.getSize());

    }
}
