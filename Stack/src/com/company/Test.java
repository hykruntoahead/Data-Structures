package com.company;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
     int opCount = 100000;
     ArrayStack<Integer> arrayStack = new ArrayStack<>();
     double time1 = testStack(arrayStack,opCount);
     System.out.println("ArrayStack ,time: "+time1 +"s");

     LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
     double time2 = testStack(linkedListStack,opCount);
     System.out.println("linkedListStack ,time: "+time2 +"s");
    }

    //测试使用queue运行opCount个enqueue和dequeue操作所需要的时间
    private static double testStack(Stack<Integer> queue,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.pop();
        }
        //....
        long endTime = System.nanoTime();
        return (endTime -startTime)/1000000000.0;
    }
}
