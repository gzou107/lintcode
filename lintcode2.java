/*
Write an algorithm which computes the number of trailing zeros in n factorial.
*/
class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        return help(n);
    }
    
    private long help(long n)
    {
        if(n <5) return 0;
        
        long count = 0;
        while(n >= 5){
            count += n/5;
            n = n/5;
        }
        
        return count;
    }
};
