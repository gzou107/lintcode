/*
lintcode 13:  strStr

For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.

Have you met this question in a real interview? Yes
Clarification
Do I need to implement KMP Algorithm in a real interview?

Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure your confirm with the interviewer first.
Example
Challenge
Tags
 Notes
If source = "source" and target = "target", return -1.

If source = "abcdabcdefg" and target = "bcd", return 1.
*/
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        return help(source, target);
    }
    
    private int help(String source, String target)
    {
        if(source == null) return -1;
        if(target == null) return -1;
        
        for(int i = 0; i <= source.length()- target.length(); i++)
        {
            int j = 0;
            for(j = 0; j<target.length() && source.charAt(i+j) == target.charAt(j); j++){
            }
            
            if(j == target.length()){
                return i;
            }
        }
        
        return -1;
    }
}