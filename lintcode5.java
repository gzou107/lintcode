/*
lintCode 5:
Kth Largest Element Show result 
Find K-th largest element in an array.
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return help(k, nums);
    }
    
    private int help(int k, int [] nums)
    {
        if(k<1 || k > nums.length) return -1;
        
        int l = 0;
        int r = nums.length - 1;
        k = nums.length - k + 1;

        while(l <= r){
            int idx = partition(nums, l, r);
            
            if(idx == k-1){
                return nums[idx];
            }else if(idx < k - 1){
                l = idx + 1;
            }else{
                r = idx - 1;
            }
        }
        
        return -1;
    }
    private int partition(int [] nums, int left, int right)
    {
        if( left == right){
            return left;
        }
        
        int pivot = nums[left];
        int l = left + 1;//starting from next node
        int r = right;
        while(l <= r)//equal here
        {
            while(l < right && nums[l] < pivot){
                l++;
            }
            
            while(r > left && nums[r] >= pivot){
                r--;
            }
            
            if(l >= r){
                break;
            }
            
            swap(nums, l, r);
        }
        
        swap(nums, left, r);
        return r;
    }
    
    private void swap(int[]nums, int l, int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
};