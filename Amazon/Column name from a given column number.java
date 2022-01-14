/*
Column name from a given column number 
Medium Accuracy: 50.98% Submissions: 3824 Points: 4
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA” and so on.

Example 1:

Input:
N = 28
Output: AB
Explanation: 1 to 26 are A to Z.
Then, 27 is AA and 28 = AB.

â€‹Example 2:

Input: 
N = 13
Output: M
Explanation: M is the 13th character of
alphabet.

Your Task:
You don't need to read input or print anything. Your task is to complete the function colName() which takes the column number N as input and returns the column name represented as a string.
 

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N <= 4294967295
*/

lass Solution
{
    String colName (long n)
    {
         StringBuffer sb=new StringBuffer();
        while(n>0){
            sb.append(charOf(n%26));
            n=(n-1)/26;
        }
        sb .reverse();
        return(sb.toString());
    }//colName
    public char charOf(long val){
        if(val==0)
            return('Z');
        else
            return((char)(64+val));
    }
}
