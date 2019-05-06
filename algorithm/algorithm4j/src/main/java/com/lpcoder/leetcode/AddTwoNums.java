package com.lpcoder.leetcode;

/**
 * @author liurenpeng
 * @date Created in 19-4-21
 */
public class AddTwoNums {

    public static void main(String[] args) {
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(3);
        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;

        System.out.println(addTwoNumbers(n11, n21).toString());

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int over = 0;
        ListNode rstPre = new ListNode(0);
        ListNode curr = rstPre;
        do {
            int tmp = l1.val + l2.val + over;
            if (tmp < 10) {
                over = 0;
                curr.next = new ListNode(tmp);
            } else {
                over = 1;
                curr.next = new ListNode(tmp - 10);
            }
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        } while (l1 != null && l2 != null);

        if (l1 != null) {
            do {
                int tmp = l1.val + over;
                if (tmp < 10) {
                    over = 0;
                    curr.next = new ListNode(tmp);
                } else {
                    over = 1;
                    curr.next = new ListNode(tmp - 10);
                }
                l1 = l1.next;
                curr = curr.next;
            } while (l1 != null);
            if (over == 1) {
                curr.next = new ListNode(1);
            }
        } else if (l2 != null) {
            do {
                int tmp = l2.val + over;
                if (tmp < 10) {
                    over = 0;
                    curr.next = new ListNode(tmp);
                } else {
                    over = 1;
                    curr.next = new ListNode(tmp - 10);
                }
                l2 = l2.next;
                curr = curr.next;
            } while (l2 != null);
            if (over == 1) {
                curr.next = new ListNode(1);
            }
        } else {
            if (over == 1) {
                curr.next = new ListNode(1);
            }
        }

        return rstPre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + (null == next ? "null" : next.toString()) +
                    '}';
        }
    }

}
