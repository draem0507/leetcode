package com.bluedream.leetcode.bytedance.other;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-17 19:26
 * @desc:
 */
public class CountDownLatchTest {


    public static void main(String[] args){

        CountDownLatch countDownLatch =new CountDownLatch(5);

        for(int i=0;i<5;i++){

            new FixHandler(countDownLatch).start();
        }


        new BossHandler(countDownLatch).start();





    }



}

class BossHandler extends  Thread{
    CountDownLatch countDownLatch;


    public BossHandler(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run(){

        try {
            System.out.println(Thread.currentThread()+" wait fix to  working");

            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread()+" know all fix handler work complete");
        }

    }


}


class FixHandler extends  Thread{
    CountDownLatch countDownLatch;


    public FixHandler(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run(){

        try {
            System.out.println(Thread.currentThread()+" start work");
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread()+" end work");
            countDownLatch.countDown();
        }

    }


}
