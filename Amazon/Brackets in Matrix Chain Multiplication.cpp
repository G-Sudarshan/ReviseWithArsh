/*
Brackets in Matrix Chain Multiplication 
Medium Accuracy: 69.46% Submissions: 1067 Points: 4
Given an array p[] of length n used to denote the dimensions of a series of matrices such that dimension of i'th matrix is p[i] * p[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications such that you need to perform minimum number of multiplications. There are many options to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same.


Example 1:

Input: 
n = 5
p[] = {1, 2, 3, 4, 5}
Output: (((AB)C)D)
Explaination: The total number of 
multiplications are (1*2*3) + (1*3*4) 
+ (1*4*5) = 6 + 12 + 20 = 38.
 

Example 2:

Input: 
n = 3
p = {3, 3, 3}
Output: (AB)
Explaination: The total number of 
multiplications are (3*3*3) = 27.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function matrixChainOrder() which takes n and p[] as input parameters and returns the string with the proper order of parenthesis for n-1 matrices. Use uppercase alphabets to denote each matrix.


Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)


Constraints:
2 ≤ n ≤ 26 
1 ≤ p[i] ≤ 500 

View Bookmarked Problems
Company Tags
Topic Tags
Related Interview Experiences
We are replacing the old Disqus forum with the new Discussions section given below.
Click here to view old Disqus comments.

*/
#define pis pair<int, string>  

class Solution{
public:
    string matrixChainOrder(int A[], int n){
        // code here
            vector<vector<pis>> DP(n-1, vector<pis>(n-1));

        for(int i = 0; i < n-1; ++i) {
            string M = "";
            M += (char) ('A' + i);
            DP[i][i] = { 0, M };
        }
        

        for(int size = 1; size <= n; ++size) {
            int l = 0;
            int m = size;

            while(m < n-1) {

                DP[l][m].first = numeric_limits<int>::max();
    
                for(int i = l; i < m; ++i) {
                    int operations = DP[l][i].first + DP[i+1][m].first + A[l]*A[i+1]*A[m+1];

                    if(DP[l][m].first > operations) {
                        DP[l][m].second = "(" + DP[l][i].second + DP[i+1][m].second + ")";
                        DP[l][m].first = operations;
                    }
                    
                }

                ++l;
                ++m;
            }
        }

        return DP[0].back().second;
    }
};
