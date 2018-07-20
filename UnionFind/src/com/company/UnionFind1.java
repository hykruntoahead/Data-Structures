package com.company;

//第一版 UnionFind  --> Quick Find
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    // O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查找元素P对应编号
    private int find(int p) {
        if (p < 0 && p > id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    //合并元素p,q所属集合 O(n)
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

    }

}
