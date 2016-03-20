/*
 Combinations Show result 

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
For example,
If n = 4 and k = 2, a solution is:
[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		return help(n, k);
    }
    
    private List<List<Integer>> help(int n, int k)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n){
            return result;
        }
        
        
        dfs(n, 1, k, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int max, int pos, int k, List<Integer> candidate, List<List<Integer>> result)
    {
        if(candidate.size() == k){
            result.add(new ArrayList<Integer>(candidate));
            return;
        }
        
        for(int i = pos; i <= max; i++)
        {
            candidate.add(i);
            dfs(max, i+1, k, candidate, result);
            candidate.remove(candidate.size()-1);
        }
    }
}