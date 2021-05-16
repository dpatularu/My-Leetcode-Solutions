/*
242. Valid Anagram
Bookkeeping algorithm.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int length = s.length();
        if(length != t.length()) return false;
        
        int[] bookkeeping = new int[26];
        
        for(int i = 0; i < length; i++){
            bookkeeping[s.charAt(i) - 'a']++;
            bookkeeping[t.charAt(i) - 'a']--;
        }
        
        for(char i = 'a'; i <= 'z'; i++){
            if(bookkeeping[i - 'a'] != 0) 
                return false;
        }
        return true;
    }
}