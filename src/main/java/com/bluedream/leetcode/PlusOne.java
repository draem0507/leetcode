package com.bluedream.leetcode;

import com.sun.org.glassfish.gmbal.AMXMBeanInterface;

import java.awt.font.NumericShaper;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-01 19:02
 * @desc:
 */
public class PlusOne {


    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }


        }
        int result[] = new int[digits.length + 1];
        result[0] = 1;
        return result;


    }


    public int[] plusOne_myself(int[] digits) {
        if (null == digits || digits.length == 0) {
            return null;
        }
        int result[] = new int[digits.length + 1];
        int num = 0;
        int len = result.length;
        boolean isFirst = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = 0;
            if (isFirst) {
                sum = digits[i] + 1;
                isFirst = false;
            } else {

                sum = digits[i] + num;
            }
            num = sum / 10;
            sum = sum % 10;
            result[len--] = sum;

        }

        return result;


    }

    public static void main(String[] args) {


        System.out.println(2/2);
        System.out.println(2%2);
    }
}
