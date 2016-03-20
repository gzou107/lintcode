/*
 Combination Sum II Show result 

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Have you met this question in a real interview? Yes
 Notice

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
Tags
Related Problems
 Notes
Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        return help(num, target);
    }
    
    private List<List<Integer>> help(int[]num, int target)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(target <= 0 || num == null || num.length == 0) return result;
        
        Arrays.sort(num);
        
        dfs(num, 0, target, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int [] num, int pos, int target, int value, List<Integer> candidate, List<List<Integer>> result)
    {
        if(target == value)
        {
            result.add(new ArrayList<Integer>(candidate));
            return;
        }
        
        if(value > target || pos >= num.length){
            return;
        }
        
        for(int i = pos; i < num.length; i++)
        {
            if(noDup(num, pos, i))
            {
                candidate.add(num[i]);
                dfs(num, i+1, target, value + num[i], candidate, result);
                candidate.remove(candidate.size()-1);
            }
        }
    }
    
    private boolean noDup(int [] num, int i, int j)
    {
        for(int m = i; m< j; m++){
            if(num[m] == num[j]){
                return false;
            }
        }
        
        return true;
    }
}