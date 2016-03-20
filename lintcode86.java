/*
 Binary Search Tree Iterator Show result 

Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
  */
  

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    
    private Stack<TreeNode> s;
    private TreeNode current;
    
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        s = new Stack<TreeNode>();
        
        TreeNode current = root;
        while(current != null){
            s.push(current);
            current = current.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !s.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode top = s.pop();
        if(top.right != null)
        {
            /*
            TreeNode newNode = top.right;
            while(newNode.left != null){
                s.push(newNode);
                newNode = newNode.left;
            }
            s.push(newNode);
            */
            TreeNode newNode = top.right;
            while(newNode != null){
                s.push(newNode);
                newNode = newNode.left;
            }
        }
        
        return top;
    }
}