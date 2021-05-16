/*
14. Longest Common Prefix
The answer cannot be larger than the smallest word, so we find the length of that.
Then we iterate over every string one letter at a time, if they have that letter in common we add it to the answer.
If there is a mismatch, we return what we built up so far.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        //Find smallest word length
        int smallestWordLength = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            smallestWordLength = Math.min(strs[i].length(), smallestWordLength);
        }
        
        //Build up our prefix
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < smallestWordLength; i++){
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }

        return sb.toString();
    }
}