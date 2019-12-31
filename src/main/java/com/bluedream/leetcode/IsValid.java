package com.bluedream.leetcode;

import java.util.Stack;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 22:12
 * @desc: 有效的括号
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> container = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (container.size() == 0) {
                container.push(c);
            } else if (isPair(container.peek(), c)) {
                container.pop();


            } else {
                container.push(c);
            }
        }

        return  container.size()==0;
    }




    private boolean isPair(char left,char right){
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');

    }
}
