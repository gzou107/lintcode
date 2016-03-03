/*
lintcode 14
First Position of Target Show result 

For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        return help(nums, target);
    }
    
    private int help(int [] nums, int target)
    {
        if(nums == null || nums.length == 0 || nums[0] > target || nums[nums.length-1] < target){
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            int m = l + ((r-l)>>1);
            
            if(nums[m]< target){
                l = m+1;
            }else{
                r = m;
            }
        }
        
        return nums[l]== target? l : -1;
    }
}