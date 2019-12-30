package com.bluedream.leetcode.bytedance.linkandtree;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-26 10:31
 * @desc: 翻转链表
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1038/
 * @refer : https://www.cnblogs.com/keeya/p/9218352.html
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(null==head){
            return null;
        }

        ListNode temp=head.next;


        ListNode result =   reverseList(head.next);

        temp.next=result;

        head.next=null;

        return  result;


    }


}
