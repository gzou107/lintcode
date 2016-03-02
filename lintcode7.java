/*
lintcode 6

 Binary Tree Serialization Show result 
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.

An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder result = new StringBuilder();
        serializeHelp(root, result);
        return result.toString();
    }
    
    private void serializeHelp(TreeNode root, StringBuilder res){
        
        if(root == null){
            res.append("null,");
            return;
        }
        
        res.append(root.val + ",");
        serializeHelp(root.left, res);
        serializeHelp(root.right, res);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == null || data.length() == 0){
            return null;
        }
        
        String[] nodes = data.split(",");
        Deque<String> dq = new ArrayDeque<String>(Arrays.asList(nodes));
        
        return deserializeHelp(dq);
    }
    
    private TreeNode deserializeHelp(Deque<String> dq){
        String top = dq.poll();
        if(top == null || top.equals("null")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(top));
        root.left = deserializeHelp(dq);
        root.right = deserializeHelp(dq);
        return root;
    }
}
