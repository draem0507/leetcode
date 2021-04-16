package leetcode.bytedance.challengeCharacter;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-11-13 02:12
 * @desc: 参考第一种方法，不过对方有bug 。其他方案待看 https://www.jianshu.com/p/4ef3cfa01367
 *
 * https://www.cnblogs.com/2463901520-sunda/p/10498955.html
 */
public class LongestCommonPrefix {





    public static String longestCommonPrefix(String [] strs){

        if(null ==strs||strs.length==0){
            return "";
        }

        if(strs.length==1){
            return strs[0];
        }

        int minLength=strs[0].length();
        String minLengthStr=strs[0];

        //获取数组集合中最小的长度，也就是公共前缀的字符最长长度
        for(int i =1;i<strs.length;i++){
            if(strs[i].length()<minLength){
                minLength=strs[i].length();
                minLengthStr=strs[i];
            }
        }
        String res="";
        while(minLength>0){

           String substring=minLengthStr.substring(0,minLength);
            boolean flag =true;
            for(int j=0;j<strs.length;j++){

                if(!strs[j].startsWith(substring)){
                    flag=false;
                    break;
                }
            }

            if(flag){
                res=substring;
                break;
            }

            minLength--;



        }


        return res;
    }

    public static void main(String[] args){
        String []strs ={"flower","flow","flight"};

       // System.out.println(longestCommonPrefix(strs));

        strs =new String[]{"dog","racecar","car"};

      //  System.out.println(longestCommonPrefix(strs));


        strs =new String[]{"ca","a"};

        System.out.println(longestCommonPrefix(strs));





    }
}
