/*
lintcode 36: Reverse Linked List II Show result 
Reverse a linked list from position m to n.

Have you met this question in a real interview? Yes
 Notice

Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
Challenge
Tags
Related Problems
 Notes
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        return help(head, m, n);
    }
    
    private ListNode help(ListNode h, int m, int n)
    {
        ListNode dummy = new ListNode(0);
        
        if(m >= n) return h;
        
        dummy.next = h;
        int i = 1;
        ListNode current = dummy;
        while(i < m)
        {
            current = current.next;
            i++;
        }
        
        ListNode prevNode = current;
        
        ListNode mNode = current.next;
        ListNode nNode = mNode;
        ListNode postNode = mNode.next;
        while(i < n)
        {
            if(postNode == null)
            {
                return null;
            }
            ListNode temp = postNode.next;
            postNode.next = nNode;
            nNode = postNode;
            postNode = temp;
            i++;
        }
        
        mNode.next = postNode;
        prevNode.next = nNode;
        
        return dummy.next;
        
    }
}