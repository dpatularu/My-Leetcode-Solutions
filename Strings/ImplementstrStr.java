/*
28. Implement strStr()
We look for the first character of needle in haystack, then we look ahead in haystack comparing to needle.
If there's a mismatch, we break the look ahead and start from where we entered and continue the search.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0; //Empty string needle starts at index 0
        if(haystack.length() == 0) return -1; //Empty haystack has no needles
        if(needle.length() > haystack.length()) return -1; //Haystack cannot have a needle larger than itself
        
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(int j = 0; j < needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)) break;
                    if( j == needle.length() - 1) return i;
                }
            }
        }
        return -1;
    }
}