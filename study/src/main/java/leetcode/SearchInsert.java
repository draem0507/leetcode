package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-01 01:45
 * @desc: 搜索插入位置
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }

        }
        //如果都没找到何时的，则返回最后一个位置
        return nums.length;
    }
}
