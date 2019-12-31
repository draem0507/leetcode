package com.bluedream.leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 20:27
 * @desc: 无重复字符的最长子串
 * @site: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }


        int pre = 0;
        int res = 0;
        int cur = 1;
        while (cur < s.length()) {
            res = Math.max(res, cur - pre);
            String temp = s.substring(pre, cur);
            char c = s.charAt(cur);
            if (temp.contains(c + "")) {
                int index = s.indexOf(c, pre);
                pre = index + 1;
            }
            cur++;

        }
        res = Math.max(res, cur - pre);

        return res;

    }


}
