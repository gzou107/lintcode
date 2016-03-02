/*
 lintocde 10
Search Range in Binary Search Tree Show result 
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12
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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        inorder(root, k1, k2, result);
        return result;
    }
    
    private void inorder(TreeNode root, int k1, int k2, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        
        while(current != null || !s.isEmpty())
        {
            // current == null, we're ready to visit the root, which is on 
            // top of stack
            if(current == null)
            {
                TreeNode top = s.pop();
                if(top.val > k2){
                    return;
                }
                
                if(top.val >= k1){
                    result.add(top.val);
                }
                current = top.right;
            }else{
                s.push(current);
                current = current.left;
            }
        }
        
        
    }
}