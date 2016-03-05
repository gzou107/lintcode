/*
lintcode 39: Recover Rotated Sorted Array Show result 

Given a rotated sorted array, recover it to sorted array in-place.

Have you met this question in a real interview? Yes
Clarification
What is rotated array?

For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
Example
Challenge
Tags
Related Problems
 Notes
In-place, O(1) extra space and O(n) time.
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        help(nums);
    }
    
    private void help(ArrayList<Integer>nums)
    {
        int min = 0;
        for(int i = 1; i < nums.size(); i++)
        {
            if(nums.get(i) < nums.get(min))
            {
                min = i;
            }
        }
        
        if( min == 0){
            return;
        }
        
        swap(nums, 0, min-1);
        swap(nums, min, nums.size()-1);
        swap(nums, 0, nums.size()-1);
    }
    
    private void swap(ArrayList<Integer> nums, int s, int e)
    {
        while(s < e)
        {
            int t = nums.get(s);
            nums.set(s, nums.get(e));
            nums.set(e, t);
            s++;
            e--;
        }
    }
}