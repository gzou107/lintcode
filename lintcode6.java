/*
lintcode 6:
Merge Sorted Array II Show result 

Merge two given sorted integer array A and B into a new sorted integer array.
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        return help(A, B);
    }
    
    private int[] help(int[]A, int [] B){
        if(A == null || A.length == 0) return B;
        if(B == null || B.length == 0) return A;
        
        int[] result = new int[A.length + B.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < A.length || j < B.length){
            if(i == A.length){
                result[k++] = B[j++];
            }else if(j == B.length){
                result[k++] = A[i++];
            }else if(A[i] < B[j]){
                result[k++] = A[i++];
            }else{
                result[k++] = B[j++];
            }
        }
        
        return result;
    }
}