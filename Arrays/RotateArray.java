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

    //Leetcode's solution using Cyclic replacements. VERY instructive and useful!
    public void cyclicRotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
          int current = start;
          int prev = nums[start]; 
          do {
            int next = (current + k) % nums.length; //next index to replace with prev
            int temp = nums[next]; //save value so it does not get destroyed in replacement
            nums[next] = prev; //replace
            prev = temp; //set prev to the replaced value
            current = next; //it will loop back to the start of the cycle eventually
            count++; //We will not iterate more than nums.length
          } while (start != current);
        }
      }

}