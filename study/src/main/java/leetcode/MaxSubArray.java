package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-01 18:21
 * @desc: 最大子序和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum=0;
        int res=nums[0];

        for(int num :nums){
            if(sum>=0){
                sum+=num;
            }else {
                sum=num;
            }
            res =Math.max(res,sum);

        }
        return res;



    }
}
