/*
lintcode 8
Rotate String Show result 
Given a string and an offset, rotate string by offset. (rotate from left to right)
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        help(str, offset);
    }
    
    private void help(char [] str, int offset)
    {
        if(offset <= 0 || str == null || str.length == 0 || offset %str.length == 0){
            return;
        }
        
        offset = offset%str.length;
        swap(str, 0, str.length-1);
        swap(str, 0, offset-1);
        swap(str, offset, str.length-1);
    }
    
    private void swap(char[] str, int i, int j){
        while(i < j){
            char ch = str[i];
            str[i] = str[j];
            str[j] = ch;
            i++;
            j--;
        }
    }
}