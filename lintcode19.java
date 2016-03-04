/*
lintcode 19: Interleaving String Show result 

Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        return help(s1,s2,s3);
    }
    
    private boolean help(String s1, String s2, String s3){
        if(s1 == null || s1.length() == 0){
            return s2==null?s3 == null: s2.equals(s3);
        }
        
        if(s2 == null || s2.length()==0){
            return s1 == null ? s3 == null : s1.equals(s3);
        }
        
        if(s1.length() + s2.length()!= s3.length()){
            return false;
        }
        
        boolean [][]cache = new boolean[s1.length()+1][s2.length()+1];
        cache[0][0] = true;
        
        for(int i = 1; i <= s1.length(); i++)
        {
            if(s1.charAt(i-1)== s3.charAt(i-1) && cache[i-1][0])
            {
                cache[i][0] = true;
            }
        }
        
        for(int j = 1; j <= s2.length(); j++)
        {
            if(s2.charAt(j-1) == s3.charAt(j-1) && cache[0][j-1])
            {
                cache[0][j] = true;
            }
        }
        
        for(int i =  1; i <= s1.length(); i++)
        {
            for(int j = 1; j <= s2.length(); j++)
            {
                if((s3.charAt(i+j-1) == s1.charAt(i-1) && cache[i-1][j]) || (s3.charAt(i+j-1) == s2.charAt(j-1) && cache[i][j-1]))
                {
                    cache[i][j] = true;
                }
            }
        }
        
        return cache[s1.length()][s2.length()];
    }
}