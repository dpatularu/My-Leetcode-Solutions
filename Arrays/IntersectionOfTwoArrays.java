/*
349. Intersection of Two Arrays
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return intersection(nums2, nums1);
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int n: nums1){
            set.add(n);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int n : nums2){
            if(set.contains(n)){
                queue.add(n);
                count++;
                set.remove(n);
            }
        }
        
        int[] answer = new int[count];
        for(int i = 0; i < answer.length; i++){
            answer[i] = queue.remove();
        }
        return answer;
    }
}