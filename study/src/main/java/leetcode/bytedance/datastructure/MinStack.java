package leetcode.bytedance.datastructure;

import java.util.Stack;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-11-14 20:19
 * @desc: https://blog.csdn.net/loophome/article/details/83749444
 */
public class MinStack {

    private Stack<Integer> container;

    private Stack<Integer> min;


    public MinStack() {
        container = new Stack();
        min = new Stack();

    }

    public void push(Integer x) {

        container.push(x);

        if (min.isEmpty() || x <= min.peek()) {

            min.push(x);
        }


    }

    public void pop() {
        if (!container.isEmpty()) {
            Integer lost = container.pop();

            if (!min.isEmpty() && lost.equals(min.peek() )) {

                min.pop();
            }


        }

    }

    public Integer top() {

        if (!container.isEmpty()) {


           return container.peek();

        }
        return 0;

    }

    public Integer getMin() {
        if (!min.isEmpty()) {

            return min.peek();
        }
        return 0;


    }


    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(-1);

        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

        System.out.println(param_3);
        System.out.println(param_4);

    }

}
