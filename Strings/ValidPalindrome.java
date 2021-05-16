/*
125. Valid Palindrome
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(!isAlphanumeric(s.charAt(left)) && left < right) left++;
            while(!isAlphanumeric(s.charAt(right)) && left < right) right--;
            char a = Character.toLowerCase(s.charAt(left));
            char b = Character.toLowerCase(s.charAt(right));
            if(a != b) return false;
            left++;
            right--;
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c){
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}