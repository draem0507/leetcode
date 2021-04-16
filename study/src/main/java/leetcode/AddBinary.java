package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-01 19:57
 * @desc: 二进制求和
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int num = 0;
        StringBuffer sb = new StringBuffer();
        while (alen >= 0 || blen >= 0 || num != 0) {

            int first = alen >= 0 ? Integer.parseInt(a.charAt(alen--) + "") : 0;
            int second = blen >= 0 ? Integer.parseInt(b.charAt(blen--) + "") : 0;
            int sum = first + second + num;
            num = sum / 2;
            sum = sum % 2;

            sb.append(sum);


        }

        return sb.reverse().toString();


    }

    public static void main(String[] args) {

        System.out.println(2 / 2);

        //  new AddBinary().addBinary("11","1");
    }


}
