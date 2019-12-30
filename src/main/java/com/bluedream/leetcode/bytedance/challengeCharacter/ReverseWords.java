package com.bluedream.leetcode.bytedance.challengeCharacter;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-21 00:21
 * @desc: https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1011/
 * 翻转字符串里的单词
 *
 * @refer https://blog.csdn.net/hq86937375/article/details/85611827
 */
public class ReverseWords {


    public String reverseWords(String s) {

        if(null==s||s.length()==0){
            return "";
        }
       String valueArr[]= s.trim().split(" +");

        StringBuilder result =new StringBuilder();
        for(int i =valueArr.length-1;i>=0;i--){

            result.append(valueArr[i]);
            if(i!=0){
                result.append(" ");
            }

        }
        return result.toString();



    }

    public static void main(String[] args){

        System.out.println( new ReverseWords().reverseWords( "the sky is blue"));
        System.out.println( new ReverseWords().reverseWords( "  hello world!  "));

    }
}
