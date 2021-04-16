package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-30 20:19
 * @desc: 两数之和
 * @site： https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> container = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (container.containsKey(target - nums[i])) {
                return new int[]{i, container.get(target - nums[i])};
            }

            container.put(nums[i], i);


        }

        return null;


    }

    public static void main(String[] args) {

        int nums[] = {1, 2, 5};
        int target = 7;

        int result[] = new TwoSum().twoSum(nums, target);

        for (int k : result) {
            System.out.println(k);
        }
    }


}
