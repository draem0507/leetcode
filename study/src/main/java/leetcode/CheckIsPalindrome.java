package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-03 00:18
 * @desc: 验证回文数
 */
public class CheckIsPalindrome {

    public boolean isPalindrome(String s) {
        if(null==s||s.length()<=1){
            return true;
        }
        String str=s.replaceAll("[^0-9a-zA-Z]","");
        int start=0; int end =str.length()-1;
        while(start<end){
        //if((s.charAt(i ++) & 0xDF) != (s.charAt(j --) & 0xDF)) return false;  直接这么写，会一直是false ?
            int a=str.charAt(start ++) & 0xDF;
            int b=str.charAt(end --) & 0xDF;
            if(a != b) {
                return false;
            }

        }
        //另外一种写法
       /*  int len = str.length();
       for (int i = 0; i < len/2; i++) {
            if(str.charAt(i)!=str.charAt(len-1-i))
                return false;
        }*/

        return true;
    }

    public static void main(String[] args){
        System.out.println( new CheckIsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

}
