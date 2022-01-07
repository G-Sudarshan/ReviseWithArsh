/*
Find the position of M-th item 
Basic Accuracy: 36.65% Submissions: 2512 Points: 1
M items are to be delivered in a circle of size N. Find the position where the M-th item will be delivered if we start from a given position K. Note that items are distributed at adjacent positions starting from K.

 

Example 1:

Input:
N = 5, M = 2, K = 1
Output:
2
Explanation:
If we start from 1st position, the
2nd item will land at the 2nd position.
Example 2:

Input:
N = 5, M = 8, K = 2
Output:
4
Explanation:
If we start from 2nd position, the
8th item will land at the 4th position.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPosition() which takes 3 Integers N,M and K as input and returns the answer.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N,M,K <= 105
*/

class Solution {
    static int findPosition(int n , int m , int k) {
        // code here
        if (m <= n - k + 1)
            return m + k - 1;
            
        m = m - (n - k + 1);
        
        return (m % n == 0) ? n : (m % n);
    }
};
