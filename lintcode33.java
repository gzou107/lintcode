/*
lintcode 33: N-Queens Show result 

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
There exist two distinct solutions to the 4-queens puzzle:

[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        return help(n);
    }
    
    private ArrayList<ArrayList<String>> help(int n)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(n == 0 || n == 2 || n == 3){
            return result;
        }
        
        dfs(n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int n, List<Integer> candidate, ArrayList<ArrayList<String>> result)
    {
        if(n == candidate.size())
        {
            buildSolution(candidate, result);
            return;
        }
        
        for(int i = 0; i < n; i++)
        {
            if(isValid(candidate, i))
            {
                candidate.add(i);
                dfs(n, candidate, result);
                candidate.remove(candidate.size()-1);
            }
        }
    }
    
    private boolean isValid(List<Integer>candidate, int newPos)
    {
        for(int i = 0; i < candidate.size(); i++)
        {
            if(candidate.get(i) == newPos || (candidate.size() - i) == Math.abs(newPos - candidate.get(i)))
            {
                return false;
            }
        }
        return true;
    }
    private void buildSolution(List<Integer>candidate, ArrayList<ArrayList<String>> result)
    {
        ArrayList<String> oneSol = new ArrayList<String>();
        for(int i = 0; i < candidate.size(); i++)
        {
            StringBuilder oneline = new StringBuilder();
            for(int j = 0; j < candidate.size(); j++)
            {
                oneline.append(j == candidate.get(i) ? "Q" : ".");
            }
            oneSol.add(oneline.toString());
        }
        result.add(oneSol);
    }
};