package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 21:52
 * @desc: 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/comments/
 */
public class RomanToInt {


    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    result = result + 1;
                    break;
                case 'V':
                    result = result + 5;
                    break;
                case 'X':
                    result = result + 10;
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'C':
                    result = result + 100;
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'M':
                    result = result + 1000;
                    break;


            }
            if (i != 0) {
                if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I'))
                    result = result - 1 * 2;
                if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X'))
                    result = result - 10 * 2;
                if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C'))
                    result = result - 100 * 2;

            }
        }
        return result;
    }

}
