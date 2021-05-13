/*
136. Single Number.
Yet another standard HashTable lookup question. However, one of Leetcode's solution was amazing.
Very clean bitwise manipulation using XOR. This works because XORs are commutative, so duplicates
cancel each other out leaving the single unique remaining. Very cool.
*/

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return nums[i];
        }
        return -1;
    }
    //Leetcode's solution.
    public int bitwiseSingleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
          a ^= i;
        }
        return a;
      }
}
