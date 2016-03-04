/*
lintcode 31: Partition Array Show result 

Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Have you met this question in a real interview? Yes
 Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Example
Challenge
Tags
Related Problems
 Notes
If nums = [3,2,2,1] and k=2, a valid answer is 1.
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    return help(nums, k);
    }
    
    private int help(int[]nums, int k)
    {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        
        int l = 0;
        int r = nums.length-1;
        while(l < r)
        {
            while(l <= r && nums[l] < k){
                l++;
            }
            
            while(r >= l && nums[r] >= k){
                r--;
            }
            
            if(l >= r){
                break;
            }
            
            swap(nums, l, r);
        }
        
        return l;
    }
    
    private void swap(int [] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}