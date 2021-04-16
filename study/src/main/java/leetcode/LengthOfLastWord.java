package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-01 18:44
 * @desc: 最后一个单词的长度
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else {
                if (res != 0) {
                    break;
                }
            }

        }
        return res;


    }

    public static void main(String[] args) {
        new LengthOfLastWord().lengthOfLastWord("  ");
    }


}
