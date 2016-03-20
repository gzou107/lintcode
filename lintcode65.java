/*
 Median of two Sorted Arrays

There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

Given A=[1,2,3] and B=[4,5], the median is 3.
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        return help(A, B);
    }
    
    private double help(int[]A, int []B){
        int len = A.length + B.length;
        
        if(len %2 == 0){
            return (help0(A, 0, B, 0, len/2) + help0(A, 0, B, 0, len/2+1))/2.0;
        }else{
            return help0(A, 0, B, 0, len/2+1);
        }
    }
    
    private double help0(int[]A, int startA, int[]B, int startB, int len)
    {
        if(startA >= A.length){
            return B[startB + len-1];
        }
        
        if(startB >= B.length){
            return A[startA + len-1];
        }
        
        if(len == 1){
            return Math.min(A[startA], B[startB]);
        }
        
        int vA = startA + len/2 - 1 >= A.length ? Integer.MAX_VALUE : A[startA + len/2 - 1];
        int vB = startB + len/2 - 1 >= B.length ? Integer.MAX_VALUE : B[startB + len/2 - 1];
        
        if(vA < vB){
            return help0(A, startA + len/2, B, startB, len - len/2);
        }else{
            return help0(A, startA, B, startB+len/2, len - len/2);
        }
    }
}
