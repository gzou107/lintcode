

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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return help(root);
    }
    
    private boolean help(TreeNode root){
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        
        if(root.val <= min || root.val >= max){
            return false;
        }
        
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}