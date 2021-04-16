package leetcode.bytedance.linkandtree;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-26 11:36
 * @desc: 合并K个排序链表
 * <p>
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1025/
 * @refer :  https://blog.csdn.net/letjava/article/details/95916957
 */
public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {

        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = new ListNode(0);
        ListNode current=result;


        while (!isEmpty(lists)) {


            current.next = getMin(lists);


            current=current.next;



        }


        return result.next;


    }

    private boolean  isEmpty(ListNode[] lists){

        for(ListNode list:lists){
            if(null!=list){
                return false;
            }
        }
        return true;

    }


    private ListNode getMin(ListNode[] lists) {

        ListNode min=null;
        int index =-1;

        for(int i=0;i<lists.length;i++){
            if(null==lists[i]) continue;
            if(null==min||lists[i].val<min.val){
                min=lists[i];
                index=i;

            }

        }
        lists[index]=min.next;

        return min;


    }



}
