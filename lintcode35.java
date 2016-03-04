/*
lintcode 35: Reverse Linked List Show result 

Reverse a linked list.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
For linked list 1->2->3, the reversed linked list is 3->2->1
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        return help(head);
    }
    
    private ListNode help(ListNode head)
    {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        
        while(next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        
        current.next = prev;
        return current;
    }
}
