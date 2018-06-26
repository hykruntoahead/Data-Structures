package com.company;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
     int opCount = 100000;
     ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
     double time1 = testQueue(arrayQueue,opCount);
     System.out.println("ArrayQueue ,time: "+time1 +"s");

     LoopQueue<Integer> loopQueue = new LoopQueue<>();
     double time2 = testQueue(loopQueue,opCount);
     System.out.println("LoopQueue ,time: "+time2 +"s");
    }

    //测试使用queue运行opcount个enqueue和dequeue操作所需要的时间
    private static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        //....
        long endTime = System.nanoTime();
        return (endTime -startTime)/1000000000.0;
    }
}
