/*
Wildcard Matching Show result 

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        return help(s, p);
     }
     
     private boolean help(String s, String p)
     {
         int sIndex  = 0;
         int pIndex = 0;
         int pStar = -1;
         int match = 0;
         
         while(sIndex < s.length())
         {
             if(pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?'))
             {
                 sIndex++;
                 pIndex++;
             }else if(pIndex < p.length() && p.charAt(pIndex) == '*')
             {
                 pStar = pIndex;
                 pIndex++;
                 match = sIndex;
             }else if(pStar != -1){
                 sIndex = match + 1;
                 match++;
                 pIndex = pStar + 1;
             }else{
                 return false;
             }
         }
         
         while(pIndex < p.length() && p.charAt(pIndex) == '*')
         {
             pIndex++;
         }
         
         return pIndex == p.length();
     }
}