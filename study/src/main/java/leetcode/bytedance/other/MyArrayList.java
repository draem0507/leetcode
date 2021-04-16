package leetcode.bytedance.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-11 15:53
 * @desc:
 */
public class MyArrayList<E> {


    private final Object[] EMPTY_ARRAYDATA = {};

    private Object[] elementData;

    private int capacity;

    public MyArrayList() {

        elementData = EMPTY_ARRAYDATA;

    }


    public MyArrayList(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException("illegal capacity " + capacity);
        }
        if (capacity == 0) {
            elementData = EMPTY_ARRAYDATA;
        } else {

            elementData = new Object[capacity];

        }
    }


    public MyArrayList(Collection<? extends  E> c) {

        if (null==c) {
            throw new IllegalArgumentException("illegal c " + c);
        }
        if (c.size() == 0) {
            elementData = EMPTY_ARRAYDATA;
        } else {

            elementData= c.toArray();
            elementData=  Arrays.copyOf(elementData,c.size(),Object[].class);

        }
        }

    public static void main(String[] args) throws InterruptedException {

        Integer object[]={1,2,3};

        List<Integer> list =  new ArrayList<Integer>(Arrays.asList(object));

        list.add(1,5);
        System.out.println(list);

        System.out.println(2^1);
        System.out.println(1^1);


        Integer i1 = 40;

        Integer i2=  Integer.valueOf(40);

        System.out.println(i1==i2);

    }





}

class  MyRunnable implements  Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);

            System.out.println("aa");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}