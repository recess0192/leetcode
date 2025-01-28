/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Leetcode002AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lhead = null;
        ListNode lend = null;

        // 进位
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode ltemp = new ListNode(sum % 10);
            if (lhead == null) {
                lhead = ltemp;
                lend = ltemp;
            } else {
                lend.next = ltemp;
                lend = ltemp;
            }

            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }

        if (l1 == null && l2 == null && carry > 0) {
            ListNode listNode = new ListNode(carry % 10);
            carry = carry / 10;
            lend.next = listNode;
            lend = listNode;
            return lhead;
        }

        while (l1 != null || l2 != null) {
            ListNode ltemp = null;
            int sum = 0;
            if (l1 != null) {
                sum = l1.val + carry;
                ltemp = new ListNode(sum % 10);
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = l2.val + carry;
                ltemp = new ListNode(sum % 10);
                l2 = l2.next;
            }

            carry = sum / 10;
            lend.next = ltemp;
            lend = ltemp;
        }

        if (carry > 0) {
            ListNode ltemp = new ListNode(carry);
            lend.next = ltemp;
        }

        return lhead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l23 = new ListNode(7);
        l1.next = l23;

        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(2);
        l2.next = l22;


        ListNode lsum = addTwoNumbers(l1, l2);
        System.out.println("done");
    }
}
