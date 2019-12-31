package com.bluedream.leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 21:15
 * @desc: 回文数
 * @site: https://leetcode-cn.com/problems/palindrome-number/
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        String str = x + "";
        int len = str.length() - 1;
        int i = 0;
        while (i <= len) {
            if (!(str.charAt(i++) == str.charAt(len--))) {
                return false;
            }

        }


        return true;
    }

    public static void main(String[] args) {

        System.out.println(-12 / 10);
        System.out.println(-12 % 10);

    }

}
