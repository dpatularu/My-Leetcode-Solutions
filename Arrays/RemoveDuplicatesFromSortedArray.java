/*26. Remove Duplicates From Sorted Array
The slow pointer populates the unique numbers at the start of the array while the fast pointer skips duplicates
until it hits a new number.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int slow = 1;
        int currentNum = nums[0];
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] == currentNum) continue;
            nums[slow] = nums[fast];
            currentNum = nums[fast];
            slow++;
        }
        return slow;
    }
}