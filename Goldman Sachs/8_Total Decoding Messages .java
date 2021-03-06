/*
Total Decoding Messages 
Medium Accuracy: 43.69% Submissions: 23892 Points: 4
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded, as the answer can be large return the answer modulo 109 + 7.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example 1:

Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).
Example 2:

Input: str = "27"
Output: 1
Explanation: "27" can be decoded as "BG".
 

Your Task:
You don't need to read or print anything. Your task is to complete the function CountWays() which takes the string as str as input parameter and returns the total number of ways the string can be decoded modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(n) where n  = |str|

Constraints:
1 <= |str| <= 104
*/

class Solution
{
    public int CountWays(String str)
    {
        // code here
        char[] digits=str.toCharArray();
        int n=digits.length;
        int[] count=new int[n+1];
        
        count[0]=1;
        count[1]=1;
        
        if(digits[0]=='0')
        return 0;
        
        for(int i=2;i<=n;i++)
        {
        count[i]=0;
        
        if(digits[i-1]>'0')
        count[i]=count[i-1];
        
        if(digits[i-2]=='1' || (digits[i-2]=='2' && digits[i-1]<'7'))
        count[i]=(count[i]%1000000007+count[i-2]%1000000007)%1000000007;
        }
        return count[n];
    }
}
