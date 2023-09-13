package org.pegasus.algorithm.class03;

public class DeleteGivenValue {
    public static ListNode removeValue(ListNode head, int num) {
        while (head != null) {
            if (head.value == num) {
                head = head.next;
            }
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre.next = cur;
            }
            cur = cur.next;
        }
        return pre;
    }

    public static ListNode removeValue2(ListNode head, int num) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.value == num) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
