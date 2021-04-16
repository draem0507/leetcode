package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-31 22:30
 * @desc: 移除元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != val) {
                nums[index++] = nums[k];
            }
        }
        return index;
    }
}
