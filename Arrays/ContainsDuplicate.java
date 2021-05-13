/*
217. Contains Duplicate
Very straight-forward hashtable lookup question.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visitedNums = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(visitedNums.contains(nums[i])) return true;
            visitedNums.add(nums[i]);
        }
        return false;
    }
}