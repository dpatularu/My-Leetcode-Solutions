class Solution {
    public int recursiveBinarySearch(int[] nums, int a, int b, int target){
        if(a > b) return -1;
        int middle = (b+a)/2;
        if(nums[middle] == target) return middle;
        
        if(target > nums[middle]){
            return recursiveBinarySearch(nums, middle+1, b, target);
        }else{
            return recursiveBinarySearch(nums, 0, middle-1,target);
        }
    }

    public int iterativeBinarySearch(int[] nums, int target) {
        int a = 0;
        int b = nums.length - 1;
        while(a <= b){
            int middle = (a+b)/2;
            if(nums[middle] == target){
                return middle;
            }else if(target > nums[middle]){
                a = middle + 1;
            }else{
                b = middle - 1;
            }
        }
        return -1;
    }

    //This implementation is cute but somewhat confusing. We iterate by jumps and we update k if we overshoot
    public int iterativeBinarySearch2(int[] nums, int target){
        int k = 0;
        for(int offset = nums.length/2; offset >= 1; offset/= 2){
            while(k+offset < nums.length && nums[k+offset] <= target) k+=offset;
        }
        if(nums[k] == target) return k;
        else return -1;
    }
}
