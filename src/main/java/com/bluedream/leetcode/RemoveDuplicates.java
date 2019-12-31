package com.bluedream.leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 21:35
 * @desc:删除排序数组中的重复项
 * @site： https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(null==nums){
            return 0;
        }
        if(nums.length<2){
            return nums.length;
        }
        int index =0;
        for(int k=1;k<nums.length;k++){
            if(nums[k]!=nums[k-1]){
                nums[++index]=nums[k];
            }
        }
        return ++index;



    }

    public static void main(String[] args){


        int arr []={1,1,2};

        new RemoveDuplicates().removeDuplicates(arr);

        System.out.println(arr.length);

    }
}
