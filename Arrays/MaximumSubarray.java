/*
    53. Maximum Subarray
    The key to this algorithm is to know when to discard previous numbers and start a new subarray.
    We accomplsih this by first assigning the best sum as the first number. Then we sum up the array
    until we hit a number that is bigger than our current sum, in which we assign that number as the 
    beginning of the subarray and update best. 
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubarraySum = 0;
        int best = nums[0];
        for(int i = 0; i < nums.length; i++){
            currentSubarraySum = Math.max(nums[i], currentSubarraySum + nums[i]);
            best = Math.max(best, currentSubarraySum);
        }
        return best;
    }
}