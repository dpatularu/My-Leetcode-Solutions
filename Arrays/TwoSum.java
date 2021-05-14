/*
1. Two Sum.
One pass HashMap solution.
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int difference = target-nums[i];
            if(set.containsKey(difference)){
                int[] answer = {i, set.get(difference)};
                return answer;
            }else{
                set.put(nums[i], i);
            }
        }
        return nums;
    }
}