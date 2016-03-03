/*
lintcode 28: Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        return help(matrix, target);
    }
    
    private boolean help(int[][]matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;
        
        while(l <= r)
        {
            int m = l + ( r-l)/2;
            if(matrix[m/col][m%col] == target){
                return true;
            }else if(matrix[m/col][m%col] < target){
                l = m + 1;
            }else{
                r = m -1;
            }
        }
        
        return false;
    }
}
