package leetcode.bytedance.arrayAndSort;

import java.util.HashMap;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-14 01:29
 * @desc: 最长连续序列  https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1019/
 *
 * @refer: https://blog.csdn.net/whdAlive/article/details/80560890
 */
public class LongestConsecutive {





    public int longestConsecutive(int[] nums) {

        if(null==nums||nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return 1;
        }

        HashMap<Integer,Integer>keyLength=new HashMap<>(nums.length*2);
        int max=0;
        for(int i=0;i<nums.length;i++){

            if(!keyLength.containsKey(nums[i])){
              int left= keyLength.getOrDefault(nums[i]-1,0);
              int right= keyLength.getOrDefault(nums[i]+1,0);
              int temp =left+right+1;

                keyLength.put(nums[i],temp);

                if(left!=0){
                    keyLength.put(nums[i]-left,temp);

                }


                if(right!=0){
                    keyLength.put(nums[i]+right,temp);

                }

                max =max>temp?max:temp;

            }
        }

        return max;

    }


}
