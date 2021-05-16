/*
344. Reverse String
Simple, but instructive for beginners.
*/

class Solution {
    //Swap algorithm
    public void reverseString(char[] s) {
        int length = s.length;
        for(int i = 0; i < length / 2; i++){
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }

    //Using a stack. This is obviouisly inferior to the above algorithm
    public void stackReverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length; i++){
            stack.push(s[i]);
        }
        
        for(int i = 0; i < s.length; i++){
            s[i] = stack.pop();
        }
    }

}