package com.bluedream.leetcode.bytedance.other;

import java.util.Scanner;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-20 16:48
 * @desc: 折半查找
 * @refer https://www.cnblogs.com/hongdada/p/6279041.html
 */
public class ZheBanSort {


    public static void main(String[] args) {

        int srcArray[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 17));


        System.out.println(binSearch(srcArray,17));


    }

    private static int binSearch(int[] srcArray, int start, int end, int key) {


        int middle = (end - start) / 2 + 1;

        if (srcArray[middle] == key) {
            return middle;
        } else if (srcArray[middle] < key) {
            return binSearch(srcArray, middle, end, key);
        } else if (srcArray[middle] > key) {
            return binSearch(srcArray, start, middle, key);

        }
        return -1;

    }


    private static int binSearch(int[] srcArray, int key) {


        int start = 0;

        int middle = srcArray.length / 2;

        if (srcArray[middle] == key) {
            return middle;
        }
        int end = srcArray.length;

        while (start <= end) {
            middle=(start+end)/2;

            if (srcArray[middle] > key) {
                end = middle-1;

            } else if (srcArray[middle] < key) {
                start = middle+1;

            }else {
                return middle;
            }

        }

        return -1;

    }


}
