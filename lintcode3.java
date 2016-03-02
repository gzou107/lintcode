 /*
 LintCOde 3
Count the number of k's between 0 and n. k can be 0 - 9.
*/ 
		class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        return help(k, n);
    }
    /*
    方法二：参考http://www.hawstein.com/posts/20.4.html分析一下会发现有如下结论

    当某一位的数字小于i时，那么该位出现i的次数为：更高位数字x当前位数
    当某一位的数字等于i时，那么该位出现i的次数为：更高位数字x当前位数+低位数字+1
    当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)x当前位数
    */
    private int help(int k, int n)
    {
        int base = 1;
        int result = 0;
        
        while(n/base > 0)
        {
            int cur = (n/base)%10;
            int low = n - (n/base)*base;
            int high = n/(base*10);
            
            if(cur < k){
                result += high *(base);
            }else if(cur == k){
                result += high*base + low + 1;
            }else{
                result += (high+1)*base;
            }
            
            base *= 10;
        }
        
         if(k == 0){
            result -=10;
         }
        return result<0?1: result;
    }
};
