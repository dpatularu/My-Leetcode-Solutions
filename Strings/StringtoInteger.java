/*
8. String to Integer (atoi)
DFA solution. This is not mine (credit to vyshnavkr on LC) but the solution is so good.
I learned about DFAs in a compiler class but to see it in action on a LC is awesome. I struggled
so hard to do this question and the code I wrote is trash. I did try to implement a DFA without knowing
albeit super clunky and convoluted. I will keep DFAs in mind from now on and think about ways I can use
state in algorithms
*/

class Solution {

    public int myAtoi(String s) {
        int value = 0;
        int state = 0;
        int sign = 1;
        
        if(s.length() == 0) return 0;
        
        for(char currentChar : s.toCharArray()){
            
            //STATE 0: Ignoring empty spaces
            if(state == 0){
                if(currentChar == ' '){
                    state = 0;
                }
                else if(currentChar == '+' || currentChar == '-'){
                    state = 1;
                    sign = currentChar == '+' ? 1 : -1;
                }else if(Character.isDigit(currentChar)){
                    state = 2;
                    value = value * 10 + (currentChar - '0');
                }else{
                    return 0;
                }
            //STATE 1: Found a + or - sign
            }else if(state == 1){
                if(Character.isDigit(currentChar)){
                    state = 2;
                    value = value * 10 + (currentChar - '0');
                }else{
                    return 0;
                }
            //STATE 2: Parsing through the number
            }else if(state == 2){
                if(Character.isDigit(currentChar)){
                    state = 2;
                    //This logic is awesome it handles overflow so elegantly.
                    if (value > Integer.MAX_VALUE / 10 
                            || (value == Integer.MAX_VALUE / 10 
                                && currentChar - '0' > Integer.MAX_VALUE % 10)) {
                            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        value = value * 10 + (currentChar - '0');
                }else{
                    break;
                }
            }else{
                return 0;
            }
        }
        
        return sign * value;
    } 
    
}
