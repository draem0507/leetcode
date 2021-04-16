package leetcode.bytedance;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-27 14:21
 * @desc:
 */
public class secondExam {


    public static void main(String[] args) {
        String first ="12345";
        String second ="45678";




        int []result=new int[first.length()];
        int mod=0;
        int []firstArr=new int[first.length()];
        int []SecondArr=new int[second.length()];


        initArr(firstArr,first);
        initArr(SecondArr,second);
        for(int i =0;i<firstArr.length;i++){
            int sum =firstArr[i]+SecondArr[i]+mod;
            mod =sum/10;
            sum =sum%10;
            result[i]=sum;

        }

        StringBuilder stringBuilder =new StringBuilder();

        for(int k: result){
            stringBuilder.append(k);
        }
        System.out.println(stringBuilder.reverse());




    }

    static void   initArr(int[]arr,String str){

        for(int i=str.length()-1,j=0;i>=0;i--){

            arr[j++]=Integer.valueOf(str.charAt(i)+"");
        }

    }
}
