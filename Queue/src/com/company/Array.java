package com.company;

public class Array<E> {
    private E[] data;
    private int size;//容量

    /**
     * @param capacity 构造函数，传入数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参数构造函数，默认容量capacity = 10
    public Array() {
        this(10);
    }

    //获取数组中元素个数
    public int getSize() {
        return size;
    }

    //获取数组中元素个数
    public int getCapacity() {
        return data.length;
    }

    //数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //数组最后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    //数组头部添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    //数组指定位置插入一个新元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,index >=0 and index < size.");
        }

        //如果数组满了 动态增长一倍长度
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //获取index索引位置元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed," +
                    "Index is illegal.");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }


    //数组中是否包含元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //从数组中删除index位置元素,返回删除元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed," +
                    "Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;// loitering object (ps:!= memory leak)

        //缩小容量
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    //删除第一个元素 返回删除元素
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个元素 返回
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    //查找元素返回位置 没找到返回 -1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    //修改索引index位置的值为e
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed," +
                    "Index is illegal.");
        }
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n",
                size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
