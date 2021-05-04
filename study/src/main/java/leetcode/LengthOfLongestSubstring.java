package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 20:27
 * @desc: 无重复字符的最长子串
 * @site: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str  ="01234561e";
        int i =str.charAt(8);
        System.out.println(i);
        System.out.println(str.charAt(8));
        System.out.println(str.substring(1,3));
        System.out.println(str.indexOf(str.charAt(1),2));

    }

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

    public int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


}
