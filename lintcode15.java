/*
lintcode 15: Permutations Show result 

Given a list of numbers, return all possible permutations.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        return help(nums);
    }
    
    
    private ArrayList<ArrayList<Integer>> help(ArrayList<Integer> nums){
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) return result;
        
        dfs(nums, 0, result);
        
        return result;
    }
    
    private void dfs(ArrayList<Integer>nums, int k, ArrayList<ArrayList<Integer>> result)
    {
        if(k == nums.size()){
            ArrayList<Integer> oneSol = new ArrayList<Integer>(nums);
            result.add(oneSol);
            return;
        }
        
        for(int i = k; i < nums.size(); i++){
            swap(nums, i, k);
            dfs(nums, k+1, result);// !!!it's k+1, not i+1, k represents the accepted length and also the 
            swap(nums, i, k);
        }
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j){
        int t= nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
}
