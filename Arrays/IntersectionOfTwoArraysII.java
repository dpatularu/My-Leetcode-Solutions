import java.util.Queue;

/*
350. Intersection of Two Arrays II
I made an inelegant, although linear, solution. I map out the values and occurances for each array and then 
check for intersections. I stick any intersections into the queue and then populate the answer array from said
queue.
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums1Map = new HashMap<>();
        HashMap<Integer, Integer> nums2Map = new HashMap<>();
        Queue<Integer> intersectionValues = new LinkedList<>();
        int intersectionCount = 0;
        
        //Map numbers to occurances for nums1
        for(int i = 0; i < nums1.length; i++){
            if(nums1Map.containsKey(nums1[i])) {
                nums1Map.replace(nums1[i], nums1Map.get(nums1[i]) + 1);
            }else{
                nums1Map.put(nums1[i], 1);
            }
        }
        
        //Map numbers to occurances for nums2
        for(int i = 0; i < nums2.length; i++){
            if(nums2Map.containsKey(nums2[i])) {
                nums2Map.replace(nums2[i], nums2Map.get(nums2[i]) + 1);
            }else{
                nums2Map.put(nums2[i], 1);
            }
        }
        
        //Check for intersections. Add intersections to queue
        for(int i = 0; i < nums1.length; i++){
            if(nums2Map.containsKey(nums1[i])){
                int numIntersections = Math.min(nums1Map.get(nums1[i]), nums2Map.get(nums1[i]));
                for(int j = 0; j < numIntersections; j++){
                    intersectionValues.add(nums1[i]);
                    intersectionCount++;
                }
                nums2Map.remove(nums1[i]);
            }
        }
        
        //Populate answer array
        int[] intersection = new int[intersectionCount];
        for(int i = 0; i < intersectionCount; i++){
            intersection[i] = intersectionValues.remove();
        }
        return intersection;
    }

    /*I added Leetcode's solution because there's so much I could learn from it. My code is super bloated and wordy
    so any chance to learn better ways to code I will take.*/
    public int[] LCintersect(int[] nums1, int[] nums2) {
        //Solves the problem of figuring out which array is larger in such an elegant way. I was blown away when I saw this
        if (nums1.length > nums2.length) {
            return LCintersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //I always had a convoluted way of incrementing things in HashMaps, so seeing this has taught me a better way to do so
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //We keep track of the number of intersections and insert said intersections into the Queue so we can create a new array later
        int intersectionCount = 0;
        Queue<Integer> intersectionValues = new LinkedList<>();
        for (int n : nums2) {
            int numIntersections = map.getOrDefault(n, 0);
            if (numIntersections > 0) {
                intersectionValues.add(n);
                map.put(n, numIntersections - 1);
                intersectionCount++;
            }
        }

        //Create the answer array
        int[] intersections = new int[intersectionCount];
        for(int i = 0; i < intersections.length; i++){
            intersections[i] = intersectionValues.remove();
        }

        return intersections;
    }
}