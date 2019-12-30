package com.bluedream.leetcode.bytedance.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-09 14:20
 * @desc:
 */
public class Test {


    private  static volatile  Test test;


    private Test(){



    }

    public static Test getInstance(){

        if(null==test){

            synchronized (Test.class){

                if(null==test){

                    test =new Test();
                }
            }
        }

        return test;
    }



    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 100, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));


        for (int i = 0; i < 100; i++) {


            threadPoolExecutor.submit(  new Thread(() -> {
                System.out.println(Test.getInstance());

            }));


        }


    /* LinkedHashMap<Integer,Integer> linkedHashMap =new LinkedHashMap();

     linkedHashMap.put(1,1);
     linkedHashMap.put(3,3);
     linkedHashMap.put(2,2);

    linkedHashMap.forEach((x,y)-> System.out.println(x));

        for (Map.Entry e : linkedHashMap.entrySet()) { System.out.println(e.getKey());}


        PriorityQueue<Integer> integers =new PriorityQueue<>();

        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(6);
        integers.add(22);
        integers.add(11);

        System.out.println(integers);
        System.out.println(integers.poll());

        System.out.println(integers);




        Object   counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        WeakReference<Object> reference = new WeakReference<>(counter, refQueue);
        counter = null;
        System.gc();


        try {
            // Remove是一个阻塞方法，可以指定timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);
            if (ref != null) {
                // do something
                System.out.println("do something");
            }else{
                System.out.println("nothing");
            }

        } catch (InterruptedException e) {
            // Handle it
            System.out.println("InterruptedException");
        }

        WeakHashMap<String,String> stringStringWeakHashMap=new WeakHashMap<>();

        stringStringWeakHashMap.put("abc","123");




        Thread thread1=   new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 1end ");
        });

        Thread thread2=   new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 2end ");
        });


        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main");


    }*/

    }



}
