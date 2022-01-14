/*
Is Sudoku Valid 
Medium Accuracy: 55.73% Submissions: 8919 Points: 4
Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix(mat[][]) the task to check if the current configuration is valid or not where a 0 represents an empty block.
Note: Current valid configuration does not ensure validity of the final solved sudoku. 
Refer to this : https://en.wikipedia.org/wiki/Sudoku

Example 1:

Input: mat[][] = [
[3, 0, 6, 5, 0, 8, 4, 0, 0]
[5, 2, 0, 0, 0, 0, 0, 0, 0]
[0, 8, 7, 0, 0, 0, 0, 3, 1]
[0, 0, 3, 0, 1, 0, 0, 8, 0]
[9, 0, 0, 8, 6, 3, 0, 0, 5]
[0, 5, 0, 0, 9, 0, 6, 0, 0]
[1, 3, 0, 0, 0, 0, 2, 5, 0]
[0, 0, 0, 0, 0, 0, 0, 7, 4]
[0, 0, 5, 2, 0, 6, 3, 0, 0]
]
Output: 1
Explaination: It is possible to have a
proper sudoku.
Your Task:
You do not need to read input or print anything. Your task is to complete the function isValid() which takes mat[][] as input parameter and returns 1 if any solution is possible. Otherwise, returns 0.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
0 ≤ mat[i][j] ≤ 9

View Bookmarked Problems
Company Tags
Topic Tags
Related Courses
We are replacing the old Disqus forum with the new Discussions section given below.
Click here to view old Disqus comments.
*/

class Solution{
    static int isValid(int mat[][]){
     int n=9;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (!isValidConfig(mat, i, j))
                     return 0;
            }
        }
        return 1;
    }
    public static boolean isValidConfig(int arr[][], int row, int col){
        return notInRow(arr, row) && notInCol(arr, col) &&
           notInBox(arr, row - row % 3, col - col % 3);
    }
    public static boolean notInBox(int arr[][], int startRow, int startCol){
         HashSet<Integer> st = new HashSet<>();
 
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                 int curr = arr[row + startRow][col + startCol];
            if (st.contains(curr))
                return false;
            if (curr != 0)
                st.add(curr);
             }
         }
         return true;
    }
    public static boolean notInCol(int arr[][], int col){
        HashSet<Integer> st = new HashSet<>();
 
        for(int i = 0; i < 9; i++){
            if (st.contains(arr[i][col]))
                 return false;
        if (arr[i][col] != 0)
            st.add(arr[i][col]);
        }
        return true;
    }
    public static boolean notInRow(int arr[][], int row){
        HashSet<Integer> st = new HashSet<>();
 
        for(int i = 0; i < 9; i++){
        if (st.contains(arr[row][i]))
            return false;
 
        if (arr[row][i] != 0)
            st.add(arr[row][i]);
        }
        return true;
    }

}
