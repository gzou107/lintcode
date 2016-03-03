/*
lintcode 17 Subsets Show result 

Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Example
Challenge
Tags
Related Problems
 Notes
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        return help(nums);
    }
    
    private ArrayList<ArrayList<Integer>> help(int[]nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(nums == null || nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(),  0, result);
        
        return result;
    }
    
    private void dfs(int[] nums, ArrayList<Integer> candidate, int pos, ArrayList<ArrayList<Integer>>result)
    {
        //if(candidate.size() <= nums.length)
        {
            result.add(new ArrayList<Integer>(candidate));
        }
        
        for(int i = pos; i < nums.length; i++)
        {
                candidate.add(nums[i]);
                dfs(nums, candidate, i+1, result);
                candidate.remove(candidate.size()-1);
        }
    }
    
}