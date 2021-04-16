package leetcode.bytedance.linkandtree;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-25 22:37
 * @desc:
 * @refer : https://blog.csdn.net/w496272885/article/details/80212426
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        ListNode result = new ListNode(0);
        ListNode next = new ListNode(0);
        result.next = next;

        do {
            int sum = (null != l1 ? l1.val : 0) + (null != l2 ? l2.val : 0) + num;
            num = sum / 10;
            sum = sum % 10;
            next.val = sum;
            l1 = null != l1 ? l1.next : l1;
            l2 = null != l2 ? l2.next : l2;
            if (null != l1 || null != l2 || 0 != num) {
                next.next = new ListNode(0);
                next = next.next;

            }

        } while (null != l1 || null != l2 || 0 != num);

        return result.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        int num = 0;
        ListNode result = new ListNode(0);
        ListNode current = new ListNode(0);

        result.next = current;

        do {
            int sum = (null != l1 ? l1.val : 0) + (null != l1 ? l2.val : 0) + num;

            num = sum / 10;
            sum = sum % 10;
            current.val = sum;
            l1 = null != l1 ? l1.next : l1;
            l2 = null != l2 ? l2.next : l2;
            if (null != l1 || null != l2 || 0 != num) {

                current.next = new ListNode(0);
                current = current.next;

            }


        } while (null != l1 || null != l2 || 0 != num);


        return result.next;


    }
}