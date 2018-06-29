package com.company;

import java.util.ArrayList;

//基于链表的集合  ---> 无序集合
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);//在链表头添加元素O(1)
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("E:\\github\\Data-Structure\\Set\\src\\com\\company\\17220.txt", words1);
        System.out.println("Total words:" + words1.size());

        LinkedListSet<String> set1 = new LinkedListSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words:" + set1.getSize());

    }
}
