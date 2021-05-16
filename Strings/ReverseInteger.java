/*
7. Reverse Integer
We turn the integer into a char array, reverse it, parse it into an integer and return. 
*/

class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        int answer = 0;
        
        char[] s = String.valueOf(Math.abs(x)).toCharArray();
        
        for(int i = 0; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }

        //Check for overflow
        try{
            answer = Integer.parseInt(new String(s));
        }catch(Exception e){
            return 0;
        }
        
        
        if(isNegative) answer *= -1;
        return answer;
    }
}