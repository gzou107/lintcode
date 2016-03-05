/*
lintcode 41: Maximum Subarray Show result 

Given an array of integers, find a contiguous subarray which has the largest sum.

Have you met this question in a real interview? Yes
 Notice

The subarray should contain at least one number.

Example
Challenge
Tags
Related Problems
 Notes
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        return help0(nums);
    }
    
    private int help0(int[]nums)
    {
        if(nums == null || nums.length == 0) return 0;
       
         int max = Integer.MIN_VALUE;
         int sum = 0;
         for(int i = 0; i < nums.length; i++)
         {
             sum += nums[i];
             max = Math.max(max, sum);
             sum = Math.max(sum, 0);
         }
         return max;
    }
    private int help(int [] nums)
    {
        if(nums == null || nums.length == 0) return 0;
        
        int gMax = nums[0];
        int lMax = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > 0 || nums[i] + lMax > 0)
            {
                gMax = Math.max(nums[i], Math.max(gMax, lMax + nums[i]));
                lMax = Math.max(nums[i], lMax + nums[i]);
            }else{
                // nums[i] < 0
                lMax = 0;
            }
        }
        
        return gMax;
        
    }
}