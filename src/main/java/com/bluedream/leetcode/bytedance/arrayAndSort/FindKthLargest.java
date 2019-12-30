package com.bluedream.leetcode.bytedance.arrayAndSort;

import java.util.Arrays;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-14 01:58
 * @desc: 数组中的第K个最大元素 https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1018/
 * @refer https://blog.csdn.net/qq_24094489/article/details/85241928
 * https://www.cnblogs.com/sunriseblogs/p/10009890.html
 */
public class FindKthLargest {


    public int findKthLargest(int[] nums, int k) {


        quickSort(nums, 0, nums.length - 1);


        Arrays.stream(nums).forEach(x-> System.out.print(x+" "));
        System.out.println();
        return nums[nums.length - k];


    }


    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {

            int middleIndex = partition(nums, low, high);

            quickSort(nums, 0, middleIndex - 1);
            quickSort(nums, middleIndex + 1, high);

        }


    }


    private int partition(int[] nums, int low, int high) {


        int compareValue = nums[low];

        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && compareValue <= nums[j]) {
                j--;
            }
            while (i < j && compareValue >= nums[i]) {
                i++;
            }
            if (i != j) {

                swap(nums, i, j);
            }


        }

        swap(nums,low,i);

        return i;


    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {


        int arr[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        FindKthLargest findKthLargest = new FindKthLargest();

        System.out.println(findKthLargest.findKthLargest(arr, k));


        arr= new int[]{-1,2,0};
         k = 1;


        System.out.println(findKthLargest.findKthLargest(arr, k));


    }


}
