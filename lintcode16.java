/*
lintcode 16 Permutations II Show result 

Given a list of numbers with duplicate number in it. Find all unique permutations.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        return help(nums);
    }
    
    private ArrayList<ArrayList<Integer>> help(ArrayList<Integer>nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) return result;
        Collections.sort(nums);
        dfs(nums, 0, result);
        return result;
    }
    
    private void dfs(ArrayList<Integer>nums, int k, ArrayList<ArrayList<Integer>>result){
        if(k == nums.size()){
            result.add(new ArrayList<Integer>(nums));
            return;
        }
        
        for(int i =k; i < nums.size(); i++)
        {
            if(noDup(nums, k, i)){
                swap(nums, i, k);
                dfs(nums, k+1, result);
                swap(nums, i, k);
            }
        }
    }
    
    private boolean noDup(ArrayList<Integer> nums, int l, int k){
        for(int i = l; i < k; i++){
            if(nums.get(i) == nums.get(k)){
                return false;
            }
        }
        return true;
    }
    private void swap(ArrayList<Integer>nums, int i, int j){
        int t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
    
}
