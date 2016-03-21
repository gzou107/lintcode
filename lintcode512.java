/*
 Decode Ways Show result 

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Have you met this question in a real interview? Yes
Example
Tags
 Notes
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.
*/


{
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        return help(s);
    }
    
    private int help(String s)
    {
        if(s == null || s.length() == 0 || s.equals("0")) return 0;
        
        int two = 1;
        int one = 1;
        int result = 1;
        
        for(int i = 2; i <= s.length(); i++)
        {
            int v0 = Integer.valueOf(s.substring(i-2, i));
            int t0 = v0 >9 && v0 <= 26 ? two : 0;
            int v1 = Integer.valueOf(s.substring(i-1, i));
            int t1 = v1 == 0? 0 : one;
            
            result = t0 + t1;
            two = one;
            one = result;
        }
        
        return result;
    }
}