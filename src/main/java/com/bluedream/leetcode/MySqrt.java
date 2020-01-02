package com.bluedream.leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-02 23:44
 * @desc: x 的平方根
 */
public class MySqrt {

    public int mySqrt(int x) {

        if(x==0){
            return 0;
        }
        if (x <= 2) {
            return 1;
        }

        int min = 0;
        int max = x;
        while (max - min > 1) {

            int middle = (max + min) / 2;

            if (x / middle < middle) {
                max=middle;
            } else {

                min = middle;
            }

        }
        return min;


    }

    public static void main(String[] args){

        System.out.println(new MySqrt().mySqrt(4));
        System.out.println(new MySqrt().mySqrt(5));
        System.out.println(new MySqrt().mySqrt(3));
    }

}
