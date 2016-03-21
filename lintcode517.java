/*
 Ugly Number Show result 

 
Write a program to check whether a given number is an ugly number`.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Have you met this question in a real interview? Yes
 Notice

Note that 1 is typically treated as an ugly number.

Example
Tags
Related Problems
 Notes
Given num = 8 return true
Given num = 14 return false
*/


public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        return help(num);
    }
    
    private boolean help(int num)
    {
        if(num <= 0) return false;
        
        while(num%5 == 0){
            num /=5;
        }
        
        while(num% 3 == 0){
            num /= 3;
        }
        
        while(num%2 == 0){
            num /= 2;
        }
        
        return num == 1;
    }
}