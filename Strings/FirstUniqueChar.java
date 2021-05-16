/*
387. First Unique Character in a String
We use a bookkeeping algorithm. We map letters to indices in the array and 
count how many times it occurs in the string. We iterate again and find the first
letter counted only once.
*/

class Solution {
    public int firstUniqChar(String s) {
        int[] bookkeeping = new int[26];
        char c;
       for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
           bookkeeping[c-'a']++;
       }
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(bookkeeping[c-'a']==1)
                return i;
        }
        return -1;
    }
    //Not mine, but why is it faster than mine? My code only iterates the array twice
    //But the implementation of indexOf and lastIndexOf are linear, so it runs at least 26 times.
    class Solution {
        public int fastFirstUniqChar(String s) {
            int min_index = s.length();
    
            for(char c = 'a'; c <= 'z'; c++) {
                int index = s.indexOf(c);
                if(index != -1 && index == s.lastIndexOf(c))
                    min_index = Math.min(min_index, index);
            }
    
            return min_index == s.length() ? -1 : min_index;
        }
    }
}