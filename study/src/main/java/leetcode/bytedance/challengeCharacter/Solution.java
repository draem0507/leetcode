package leetcode.bytedance.challengeCharacter;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-10 01:32
 * @desc: https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1016/
 * @refer https://blog.csdn.net/Fly_Fly_Zhang/article/details/86635635
 */
public class Solution {


    public boolean checkInclusion(String s1, String s2) {
      if(null==s1||null==s2||s2.length()<s1.length()){
          return false;

      }
     int [] num1 =new int[26];

      int[] num2 =new int[26];

      for(int i =0;i<s1.length();i++){

          num1[s1.charAt(i)-'a']++;
          num2[s2.charAt(i)-'a']++;

      }
      int compare[]=new int[26];
      for(int i=0;i<compare.length;i++){

          compare[i]=num2[i]-num1[i];
      }

      for(int j=0;j+s1.length()<s2.length();j++){

          if(isSame(compare)){

              return true;
          }
          //滑动
          compare[s2.charAt(j)-'a']--;
          compare[s2.charAt(j+s1.length())-'a']++;


      }

      return  isSame(compare);





    }


    private boolean isSame(int arr[]){
        for(int i=0;i<arr.length;i++){

            if(arr[i]!=0){
                return false;
            }
        }
        return true;

    }






    public static void main(String[] args){



        Solution solution =new Solution();
        System.out.println( solution.checkInclusion("ab", "eidbaooo"));

        System.out.println( "A".charAt(0)-'a');
        System.out.println( new Integer("A".charAt(0)));//65
        System.out.println( new Integer("a".charAt(0)));//97
    }
}
