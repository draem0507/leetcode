package com.bluedream.leetcode.bytedance.linkandtree;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-26 10:23
 * @desc:
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode result = null;

        if (l1.val <= l2.val) {

            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);

        }

        return result;


    }


}
