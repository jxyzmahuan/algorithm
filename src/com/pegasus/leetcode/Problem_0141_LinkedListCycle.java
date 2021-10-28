package com.pegasus.leetcode;

public class Problem_0141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while(slow!=fast){
            if (fast == null || fast.next == null) {
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
