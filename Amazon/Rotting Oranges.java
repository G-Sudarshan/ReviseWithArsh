/*
994. Rotting Oranges
Medium

5605

255

Add to List

Share
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
Accepted
325,067
Submissions
632,446
*/

class Solution {
    public int orangesRotting(int[][] grid) {
         Queue<int[]> que = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2)
                    que.offer(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return 0;
        int l, t=0;
        int r,c;
        while(!que.isEmpty()){
            l = que.size();
            while(l>0){
                r=que.peek()[0];
                c=que.peek()[1];
                que.poll();
                
                if(r<grid.length-1 && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    fresh--;
                    que.offer(new int[]{r+1,c});
                }
                if(c<grid[0].length-1 && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    fresh--;
                    que.offer(new int[]{r,c+1});
                }
                if(r>0 && grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    fresh--;
                    que.offer(new int[]{r-1,c});
                }
                if(c>0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    fresh--;
                    que.offer(new int[]{r,c-1});
                }
                l--;
            }
            t++;
        }
        if(fresh>0)
            return -1;
        return t-1;
    }
}
