package com.bluedream.leetcode.bytedance.other;

import java.util.BitSet;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-13 14:45
 * @desc: 布隆过滤器
 * @refer :https://github.com/Snailclimb/JavaGuide/blob/master/docs/dataStructures-algorithms/data-structure/bloom-filter.md
 */
public class BloomFilter<T> {


    private static final int DEFAULT_CAPACITY = 1 >> 30;


    private static final int[] SEED = {3, 11, 31, 51, 91, 131};


    private BitSet bitSet = new BitSet(DEFAULT_CAPACITY);
    private SimpleHash[] simpleHashes = new SimpleHash[SEED.length];


    public BloomFilter() {


        for (int i = 0; i < SEED.length; i++) {

            simpleHashes[i] = new SimpleHash(SEED[i], DEFAULT_CAPACITY);
        }
    }


    public void add(T value) {
        int hash = 0;

        for (int i = 0; i < SEED.length; i++) {

            hash = simpleHashes[i].hashcode(value);
            bitSet.set(hash, true);


        }
    }


    public boolean contains(T value) {

        boolean flag = true;
        int hash = 0;

        for (int i = 0; i < SEED.length; i++) {

            hash = simpleHashes[i].hashcode(value);
            if (!(flag = bitSet.get(hash))) {
                break;
            }

        }

        return flag;

    }


    static class SimpleHash {

        int seed;
        int capacity;

        SimpleHash(int seed, int capacity) {

            this.seed = seed;
            this.capacity = capacity;
        }


        public int hashcode(Object value) {


            int h;

            return Math.abs(seed * (DEFAULT_CAPACITY - 1)) & ((h = value.hashCode()) ^ (h >>> 16));


        }


    }

    public static void main(String[] args) {


        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }


}
