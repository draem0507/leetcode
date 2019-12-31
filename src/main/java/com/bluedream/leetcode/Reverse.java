package com.bluedream.leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 21:02
 * @desc: 整数反转
 * @site: https://leetcode-cn.com/problems/reverse-integer/
 */
public class Reverse {


    public int reverse(int x) {

        long res = 0L;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;

        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;


    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(123));
    }
}
