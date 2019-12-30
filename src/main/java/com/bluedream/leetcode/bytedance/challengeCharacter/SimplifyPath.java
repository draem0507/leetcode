package com.bluedream.leetcode.bytedance.challengeCharacter;

import java.util.Stack;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-21 00:43
 * @desc: 简化路径 https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1013/
 *
 * @refer https://blog.csdn.net/ztf312/article/details/51051463
 * https://zhuanlan.zhihu.com/p/92379563
 */
public class SimplifyPath {


    public String simplifyPath(String path) {
        if(null==path||path.length()==0){
            return "";
        }
       String pathArr[]= path.split("/");

        Stack stack =new Stack();

        for(String p:pathArr){

            if(p.equals("..")){
                if(stack.size()>0) {
                    stack.pop();
                }
            }else if(p.equals(".")||p.equals("")){
                continue;
            }else {

                stack.push(p);
            }
        }
        StringBuilder result =new StringBuilder();
        if(stack.size()==0) {
            result.append("/");
        }else {
            stack.forEach(x -> result.append("/").append(x));
        }


        return  result.toString();

    }


    public static void main(String[] args){
        System.out.println(new SimplifyPath().simplifyPath("/home/") );
    }
}
