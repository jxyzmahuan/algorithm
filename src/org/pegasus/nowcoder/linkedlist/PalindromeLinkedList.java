package org.pegasus.nowcoder.linkedlist;


import java.util.Stack;

public class PalindromeLinkedList {


    public boolean isPalindrome(ListNode head){
        Stack<ListNode> stack=new Stack<>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(head!=null){
            if(head.val!=stack.pop().val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
