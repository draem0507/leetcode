package leetcode.bytedance.challengeCharacter;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-11-13 01:05
 * @desc: https://blog.csdn.net/HaleyDong/article/details/90768946
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        //一个指针pre指向无重复子字符串的开头，一个指针cur移动指向当前字符（子字符串的结尾是cur-1），子字符串长度即为两者的差
        //判断子字符串中 是否含有cur当前指向的元素，若不含，则cur+1；
        //若包含，找出子字符串中重复该元素的位置,将pre指向下一个元素。cur继续回到判断这一步，直到将整个字符串都遍历
        if(null==s||s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int pre = 0;
        int cur = 1;
        int res = 0;
        while(cur < s.length() ){
            res = Math.max(res, cur-pre);
            String tmp = s.substring(pre, cur);
            System.out.println("tmp= " + tmp);
            char x = s.charAt(cur);
            System.out.println("x= " + x);
            if(tmp.contains(x+"") ){
                int i = s.indexOf(x, pre);
                System.out.println("i=="+i);
                pre = i+1;
            }
            cur++;
        }
        res = Math.max(res, cur-pre);
        return res;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcbbcbb"));

    }


}
