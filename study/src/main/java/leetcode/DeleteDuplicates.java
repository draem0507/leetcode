package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2020-01-01 21:48
 * @desc: 删除排序链表中的重复元素
 */
public class DeleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        if(null==head||null==head.next){
            return head;
        }

        int  temp=head.val;

        if(temp==head.next.val){
            head=deleteDuplicates(head.next);
        }else {
            head.next=deleteDuplicates( head.next);

        }
        return head;

    }
}
