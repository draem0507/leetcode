package leetcode.bytedance.challengeCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-21 01:14
 * @desc: 复原IP地址 https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1044/
 * @refer  https://www.cnblogs.com/grandyang/p/4305572.html
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        if (null == s || s.length() == 0) {
            return null;
        }

        List<String> result = new ArrayList<>();

        if (s.length() == 4) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {

                sb.append(Integer.parseInt(s.charAt(i) + ""));
                if (i != s.length() - 1) {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
            return result;
        }

        helper(s, 0, "", result);


        return result;
    }

    private void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) {
                res.add(out);
            }
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }


    }

    public static void main(String[] args) {

        System.out.println(new RestoreIpAddresses().restoreIpAddresses("12345"));

    }
}
