/*
lintcode 34: N-Queens II Show result 

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
For n=4, there are 2 distinct solutions.
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        return help(n);
    }
    
    private int help(int n){
        if(n == 0 || n == 2 || n == 3){
            return 0;
        }
        
        int[]count = new int[1];
        //count[0] = 0;
        dfs(n, new ArrayList<Integer>(), count);
        
        return count[0];
    }
    
    private void dfs(int n, List<Integer>candidate, int []count)
    {
        if(n == candidate.size()){
            count[0]++;
            return;
        }
        
        for(int i = 0; i < n; i++)
        {
            if(isValid(candidate, i))
            {
                candidate.add(i);
                dfs(n, candidate, count);
                candidate.remove(candidate.size()-1);
            }
        }
    }
    
    private boolean isValid(List<Integer>candidate, int newPos)
    {
        for(int i = 0; i < candidate.size(); i++)
        {
            if(candidate.get(i) == newPos || candidate.size() - i == Math.abs(newPos - candidate.get(i)))
            {
                return false;
            }
        }
        
        return true;
    }
};

