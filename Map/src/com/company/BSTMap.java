package com.company;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }


    //添加新的元素(key,value)
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //递归
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {//key.compareTo(node.key) == 0
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }

        if (k.compareTo(node.key) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if (k.compareTo(node.key) > 0) {
            node.right = remove(node.right, k);
        } else { //e == compareTo(node.e)

            //待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除的节点左右子树均不为空
            //找到比待删除节点大的最小节点 替代
            Node successor = minimum(node.right);
            //注意:在removeMin做了size--
            successor.right = removeMin(node.right);
//            size--;
            successor.left = node.left;
//            size++;
            node.left = node.right = null;
            return successor;
        }
        return null;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }


    public static void main(String[] args) {
        System.out.println("THE CATCHER IN THE RYE");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation
                .readFile("E:\\github\\Data-Structure\\Map\\src\\17220.txt",
                        words)) {
            System.out.println("Total words:" + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words:" + map.getSize());
            System.out.println("like count:" + map.get("like"));
        }
    }
}
