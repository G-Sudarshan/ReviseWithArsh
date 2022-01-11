/*
209. Minimum Size Subarray Sum
Medium

5444

166

Add to List

Share
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
Accepted
452,912
Submissions
1,073,750
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0 , j = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        
        while(j < n){
            if(j < n && currSum >= target){
                currSum += nums[j++];
            }
            
            while(j < n && currSum < target){
                currSum += nums[j++];
            }
            
            if(currSum >= target){
                
                while(i< j && currSum - nums[i] >= target){
                    currSum -= nums[i++];
                }
                
                min = Math.min(min , j- i);
            }
            
            
        }
        
        if(min == Integer.MAX_VALUE) return 0;
        
        return min ;
    }
}
