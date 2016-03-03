/*
lintcode 18: Subsets II Show result 

Given a list of numbers that may has duplicate numbers, return all possible subsets

Have you met this question in a real interview? Yes
 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Example
Challenge
Tags
Related Problems
 Notes
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        return help(S);
    }
    
    private ArrayList<ArrayList<Integer>> help(ArrayList<Integer>nums){
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        Collections.sort(nums);
        dfs(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }
    
    private void dfs(ArrayList<Integer>nums, ArrayList<Integer>candidate, int pos, ArrayList<ArrayList<Integer>> result)
    {
        result.add(new ArrayList<Integer>(candidate));
        
        for(int i = pos; i < nums.size(); i++)
        {
            if(noDup(nums, pos, i))
            {
                candidate.add(nums.get(i));
                dfs(nums, candidate, i+1, result);
                candidate.remove(candidate.size()-1);
            }
        }
    }
    
    private boolean noDup(ArrayList<Integer> nums, int l, int pos)
    {
        for(int i = l; i < pos; i++)
        {
            if(nums.get(i) == nums.get(pos))
            {
                return false;
            }
        }
        
        return true;
    }
}
