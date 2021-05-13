/*
189. Rotate Array
Every index in rotatedNums can be mapped to an index in nums.
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotatedNums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            rotatedNums[(k+i)%nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = rotatedNums[i];
        }
    }
}