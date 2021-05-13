/*
    912. Sort an Array.
*/

class Solution {
    public int[] bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp; 
                }
            }
        }
        return nums; 
    }

    public int[] insertionSort(int[] nums){
        for(int i = 0; i < nums.length-1; i++){
            int j = i;
            while(j >= 0 && nums[j+1] < nums[j]){
                int temp = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    public int[] countingSort(int[] nums) {
        int largestNum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > largestNum) largestNum = nums[i];
        }
        
        int[] bookkeepingArray = new int[largestNum+1];
        
        for(int i = 0; i < nums.length; i++){
            bookkeepingArray[nums[i]]++;
        }
        
        int numsPointer = 0;
        for(int i = 0; i < bookkeepingArray.length; i++){
            for(int j = 0; j < bookkeepingArray[i]; j++){
                nums[numsPointer] = i;
                numsPointer++;
            }
        }
        return nums;
        
    }
}
