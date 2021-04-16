package leetcode.bytedance.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-09 19:19
 * @desc: leetCode https://leetcode-cn.com/explore/featured/card/bytedance/245/data-structure/1033/
 * @refer: https://blog.csdn.net/LaputaFallen/article/details/79903560
 */
public class AllOne {


    private Bucket head;

    private Bucket tail;

    private HashMap<String, Integer> keyCount;


    private HashMap<Integer, Bucket> countBucket;


    public AllOne() {

        keyCount = new HashMap<>();
        countBucket = new HashMap<>();

        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);

        head.next = tail;
        tail.pre = head;


    }

    public void inc(String key) {

        if (keyCount.containsKey(key)) {

            //add+1
            changeKey(key, 1);


        } else {

            //init
            keyCount.put(key, 1);
            if (head.next.count != 1) {
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keySet.add(key);
            countBucket.put(1, head.next);

        }


    }

    public void dec(String key) {

        if (keyCount.containsKey(key)) {
            int count = keyCount.get(key);
            Bucket curBucket = countBucket.get(count);
            if (curBucket.count == 1) {
                keyCount.remove(key);
                removeKeyFromBucket(curBucket, key);
            } else {
                changeKey(key, -1);
            }
        }

    }



    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keySet.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void changeKey(String key, int offset) {

        int count = keyCount.get(key);
        int newCount = count + offset;
        keyCount.put(key, newCount);

        Bucket curBucket = countBucket.get(count);


        Bucket newBucket;

        if (countBucket.containsKey(newCount)) {

            newBucket = countBucket.get(newCount);
        } else {

            newBucket = new Bucket(newCount);

            countBucket.put(newCount, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.pre);

        }

        newBucket.keySet.add(key);

        removeKeyFromBucket(curBucket, key);


    }

    private void removeKeyFromBucket(Bucket curBucket, String key) {
        curBucket.keySet.remove(key);
        if (curBucket.keySet.size() == 0) {

            removeBucketFromList(curBucket);
            countBucket.remove(curBucket.count);
        }

    }

    private void removeBucketFromList(Bucket curBucket) {

        curBucket.pre.next = curBucket.next;
        curBucket.next.pre = curBucket.pre;
        curBucket.next = null;
        curBucket.pre = null;
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.next = preBucket.next;
        newBucket.pre = preBucket;
        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;


    }


    class Bucket {


        private int count;

        private Set<String> keySet;

        private Bucket pre;

        private Bucket next;


        public Bucket(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }


    }


    public static void main(String[] args) {
        /**
         *
         *
         */

        AllOne allOne = new AllOne();


        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");


        System.out.println(allOne.getMinKey());

        allOne.dec("a");


        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());


    }

}
