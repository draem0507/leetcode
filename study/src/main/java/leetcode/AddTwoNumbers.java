package leetcode;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-30 23:12
 * @desc: 两数相加
 * @site: https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (null == l1) return l2;

        if (null == l2) return l1;

        ListNode result = new ListNode(0);
        ListNode current = new ListNode(0);
        result.next = current;
        int num = 0;

        do {

            int sum = (null != l1 ? l1.val : 0) + (null != l2 ? l2.val : 0) + num;
            num = sum / 10;
            sum = sum % 10;
            current.val = sum;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
            if (null != l1 || null != l2 || num != 0) {

                current.next = new ListNode(0);

                current = current.next;
            }


        } while (null != l1 || null != l2 || num != 0);


        return result.next;

    }

    public static void main(String[] args) {

    }
}
