/*
845. Longest Mountain in Array
Medium

1662

53

Add to List

Share
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

 

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
*/

class Solution {
    public int longestMountain(int[] arr) {
        int globalMax = 0;
        int incCount = 0;
        int decCount = 0;
        int prev = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == 0 || (diff > 0 && prev <= 0)) {
                if (incCount != 0 && decCount != 0) {
                    int totalCount = incCount + decCount + 1;
                    globalMax = Math.max(globalMax, totalCount);
                }
                incCount = 0;
                decCount = 0;
            }
            if (diff < 0) {
                decCount++;
            }
            if (diff > 0) {
                incCount++;
            }
            if (incCount != 0 && decCount != 0 && i == arr.length - 2) {
                int totalCount = incCount + decCount + 1;
                globalMax = Math.max(globalMax, totalCount);
            }
            prev = diff;
        }

        return globalMax;
        
    }
}
