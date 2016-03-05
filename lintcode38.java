/*
lintcode 38: Search a 2D Matrix II Show result 

Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        //return help0(matrix, target);
        return help(matrix, target);
    }
    
    private int help0(int[][]m, int t)
    {
         if(m == null || m.length == 0 || m[0].length == 0) return 0;
        
        // from bottom left to top right
        int count = 0;
        int i = m.length-1;
        int j = 0;
        
        while(i >=0 && j < m[0].length)
        {
            if(m[i][j] < t){
                j++;
            }else if(m[i][j] > t){
                i--;
            }else{
                count++;
                i--;
                j++;
            }
        }
        
        return count;
    }
    private int help(int[][]m, int t)
    {
        if(m == null || m.length == 0 || m[0].length == 0) return 0;
        
        // assuming the columns count small than row count
        int count = 0;
        int row = m.length;
        int col = m[0].length;
        //if(row < col)
        {
            // do column binary search
            for(int i = 0; i < col; i++)
            {
                if(m[0][i] > t || m[row-1][i] < t)
                {
                    continue;
                }else
                {
                    int up = 0;
                    int down = row - 1;
                    while(up <= down)
                    {
                        int mid = up + (down - up)/2;
                        if(m[mid][i] == t)
                        {
                            count++;
                            break;
                        }else if(m[mid][i] < t)
                        {
                            up = mid + 1;
                        }else
                        {
                            down = mid -1;
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
