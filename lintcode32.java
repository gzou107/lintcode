/*
lintcode 32: Minimum Window Substring Show result 

Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

Have you met this question in a real interview? Yes
 Notice

If there is no such window in source that covers all characters in target, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
Challenge
Tags
 Notes
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        return help0(source, target);
    }
    
       int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    
    public String help0(String source, String target)
    {
        int []targetHash = new int[256];
        int targetNum = target.length();
        for(int i = 0; i < target.length(); i++){
            targetHash[target.charAt(i)]++;
        }
        
        int min = source.length()+1;
        String result = "";
        
        int i = 0;
        int j = 0;
        int sourceNum = 0;
        for(i = 0; i < source.length(); i++)
        {
            if(targetHash[source.charAt(i)] > 0){
                sourceNum++;
            }
            
            targetHash[source.charAt(i)]--;
            
            while(sourceNum >= targetNum){
                if(min > i - j + 1){
                    min = i - j + 1;
                    result = source.substring(j, i + 1);
                }
                // narrow down j if possible
                targetHash[source.charAt(j)]++;
                if(targetHash[source.charAt(j)] > 0){
                    sourceNum--;
                }
                j++;
            }
        }
        
        return result;
    }
    
    private String help(String s, String t)
    {
        if(s == null || s.length() == 0) return t == null ? t :"";
        if(t == null || t.length() == 0) return "";
        if(s.length() < t.length()) return "";
        
        int min = s.length() + 1;
        int gStart = -1;
        int[]count = new int [256];
        int dCount = 0;
        for(int i = 0; i < t.length(); i++)
        {
            count[t.charAt(i)]++;
            if(count[t.charAt(i)] == 1)
            {
                dCount++;
            }
        }
        
        int[] rCount = new int[256];
        int i = 0;
        int matchCount = 0;
        while(i < s.length() && count[s.charAt(i)] == 0)
        {
            i++;
        }
        if(i == s.length()){
            return "";
        }
        gStart = i;
        String result = "";
        
        // search mode, find one solution
        for(; i < s.length(); i++)
        {
            rCount[s.charAt(i)]++;
            
                if(rCount[s.charAt(i)] == count[s.charAt(i)])
                {
                    matchCount++;
                    if(matchCount == dCount)
                    {
                        while(rCount[s.charAt(gStart)] > count[s.charAt(gStart)] )
                        {
                            rCount[s.charAt(gStart)]--;
                            gStart++;
                        }
                        
                        if( i - gStart + 1 < min)
                        {
                            min = i - gStart + 1;
                            result = s.substring(gStart, i+1);
                           
                        }
                        
                          break;
                   }
                  
                }
        }
        i++;
        // now we enter maintenance mode
        for(; i < s.length(); i++)
        {
            rCount[s.charAt(i)]++;
            if(s.charAt(gStart) == s.charAt(i))
            {
                rCount[s.charAt(gStart)]--;
                gStart++;
                while(rCount[s.charAt(gStart)] > count[s.charAt(gStart)])
                {
                    rCount[s.charAt(gStart)]--;
                    gStart++;
                }
                
                if( i - gStart + 1 < min)
                {
                    min = i - gStart + 1;
                    result = s.substring(gStart, i+1);
                }
            }
        }
        
        return result;
    }
}