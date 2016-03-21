/*
 Lowest Common Ancestor Show result 

Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
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
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        return help(root, A, B);
    }
    
    private TreeNode help(TreeNode root, TreeNode A, TreeNode B){
        
        if(root == null || root == A || root == B){
            return root;
        }
        
        TreeNode l = help(root.left, A, B);
        TreeNode r = help(root.right, A, B);
        
        if(l != null && r != null){
            return root;
        }
        
        return l != null ? l : r;
    }
}