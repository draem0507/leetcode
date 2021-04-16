package leetcode.bytedance;

import java.util.HashMap;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-19 14:15
 * @desc: 12345.67 输出一万两千三百四十五六角七分
 */
public class FirstExam {




    public static void main(String[] args) {
        double value = 12345.67D;
      //  method1(value);



        String str=String.valueOf(value);

        HashMap<Integer ,String>big=new HashMap<>();
        big.put(1,"万");
        big.put(2,"千");
        big.put(3,"百");
        big.put(4,"十");
        big.put(5,"个");
        big.put(6,"角");
        big.put(7,"分");

       String valueArr[]= str.split("\\.");
       StringBuilder stringBuilder =new StringBuilder();

       for(int k=0;k<valueArr.length;k++) {
           for (int i = 0; i < valueArr[k].length(); i++) {

               char key = valueArr[k].charAt(i);

               String temp = big.getOrDefault(Integer.parseInt(key+""), "0");

               stringBuilder.append(key).append(temp);

           }
       }


        System.out.println(stringBuilder);


    }






    private static void method1(double value ) {

         String bigMoney[] = {"万", "千", "百", "十", "元"};

         String smallMoney[] = {"角", "分"};

        String valueToStr = String.valueOf(value);

        String valueArr[] = valueToStr.split("\\.");


        int[] smallResult = null;
        //说明有小数点

        int smallTemp = 0;
        if (valueArr.length > 1) {
            smallTemp = Integer.valueOf(valueArr[1]);
            smallResult = new int[valueArr[1].length()];
        }

        int temp = Integer.valueOf(valueArr[0]);

        int[] bigResult = new int[valueArr[0].length()];

        int hasWan = 0;
        int hasQian = 0;
        int hasBai = 0;
        int hasShi = 0;
        int hasGe = 0;

        int hasJiao = 0;
        int hasFen = 0;

        if (valueArr[0].length() == 5) {

            hasWan = temp / 10000;
            hasQian = temp / 1000 % 10;
            hasBai = temp / 100 % 10;
            hasShi = temp / 10 % 10;
            hasGe = temp % 10;

        } else if (valueArr[0].length() == 4) {

            hasQian = temp / 1000 % 10;
            hasBai = temp / 100 % 10;
            hasShi = temp / 10 % 10;
            hasGe = temp % 10;

        } else if (valueArr[0].length() == 3) {
            hasBai = temp / 100 % 10;
            hasShi = temp / 10 % 10;
            hasGe = temp % 10;


        } else if (valueArr[0].length() == 2) {

            hasShi = temp / 10 % 10;
            hasGe = temp % 10;

        } else if (valueArr[0].length() == 1) {

            hasGe = temp % 10;
        }


        if (valueArr.length > 1) {


            if (valueArr[1].length() == 2) {


                hasFen = smallTemp / 10;
                hasJiao = smallTemp % 10;

            } else if (valueArr[0].length() == 1) {

                hasFen = smallTemp;


            }

        }


        bigResult[0] = hasWan;
        bigResult[1] = hasQian;
        bigResult[2] = hasBai;
        bigResult[3] = hasShi;
        bigResult[4] = hasGe;

        smallResult[0] = hasJiao;
        smallResult[1] = hasFen;


        StringBuilder stringBuilder = new StringBuilder();

        for (int k = 0; k < bigResult.length; k++) {
            stringBuilder.append(bigResult[k]).append(bigMoney[k]);
        }

        for (int k = 0; k < smallResult.length; k++) {
            stringBuilder.append(smallResult[k]).append(smallMoney[k]);
        }


        System.out.println(stringBuilder.toString());
    }

}
