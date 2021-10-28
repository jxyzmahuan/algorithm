package com.pegasus.leetcode;

public class Problem_0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int carry = 0;//进位
        ListNode result = null, tail = null;
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            if (result == null) {
                result = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return result;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}