/*
lintcode 49: Sort Letters by Case Show result 

Given a string which contains only letters. Sort it by lower case first and upper case second.

Have you met this question in a real interview? Yes
 Notice

It's NOT necessary to keep the original order of lower-case letters and upper case letters.

Example
Challenge
Tags
 Notes
For "abAcD", a reasonable answer is "acbAD"
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        help(chars);
    }
    
    private void help(char [] chars)
    {
        List<Character> ch = new ArrayList<Character>();
        for(char cha : chars){
            ch.add(cha);
        }
        
        Collections.sort(ch, Collections.reverseOrder());
        for(int i = 0; i < ch.size(); i++){
            chars[i] = ch.get(i);
        }
    }
}
