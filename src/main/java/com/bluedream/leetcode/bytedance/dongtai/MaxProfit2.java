package com.bluedream.leetcode.bytedance.dongtai;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-14 21:35
 * @desc: https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1042/
 * 买卖股票的最佳时机2
 * @refer :https://www.jianshu.com/p/8b2f1fe4a964
 */
public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        if(null==prices||prices.length<=1){
            return 0;
        }

       int max=0;
       int min=prices[0];
       for(int i=1;i<prices.length;i++){


           max=max+Math.max(0,prices[i]-prices[i-1]);
       }


        return max;



    }

    public static void main(String[] args){

        int arr[]={7,1,5,3,6,4};

        System.out.println(new MaxProfit2().maxProfit(arr));

        int arr2[]={7,6,4,3,1};

        System.out.println(new MaxProfit2().maxProfit(arr2));
    }
}
