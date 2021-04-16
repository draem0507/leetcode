package leetcode.bytedance.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-22 20:29
 * @desc:
 */
public class ThreadPoolTest {


    public static void main(String[] args){


        ThreadPoolExecutor threadPoolExecutor=  new ThreadPoolExecutor(1,2,60,TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),new ThreadPoolExecutor.CallerRunsPolicy());





        for(int i =0;i<10;i++){

            threadPoolExecutor.execute(new IdentifyTask(i));
        }


        //threadPoolExecutor.shutdown();


    }
}

class IdentifyTask extends Thread{
    int id;

    public IdentifyTask(int id){
        this.id =id;

    }
    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName()+":"+id);
        try {
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+":"+id+"\t "+e.getMessage());
        }

    }

}
