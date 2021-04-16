package leetcode.bytedance.datastructure;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-11-14 21:39
 * @desc:
 */
public class LRUCache {


    private Stack<Integer> stack;

    private int capacity;
    private HashMap<Integer, Integer> containers;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        stack = new Stack();
        containers = new HashMap<>();


    }


    public int get(int key) {

        if (stack.contains(Integer.valueOf(key))) {
            stack.remove(Integer.valueOf(key));
            stack.push(Integer.valueOf(key));
            return containers.get(Integer.valueOf(key));

        }

        return -1;


    }

    public void put(int key, int value) {
        if (stack.contains(Integer.valueOf(key))) {
            stack.remove(Integer.valueOf(key));

        } else {

            if (capacity == containers.size()) {
                Integer eldest = stack.remove(0);
                containers.remove(eldest);
            }
        }

        stack.push(Integer.valueOf(key));
        containers.put(Integer.valueOf(key), value);


    }

    public static void main(String[] args) {
        /**
         * ["LRUCache","put","put","get","put","get","put","get","get","get"]
         * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         */
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));


    }


}
