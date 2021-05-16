/*
66. Plus One
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int lastDigit = digits.length - 1;
        digits[lastDigit]++;
        for(int i = digits.length - 1; i > 0; i--){
            if(digits[i] == 10){
                digits[i] = 0;
                digits[i-1]++;
            }
        }
        
        if(digits[0] == 10){
            int[] newDigits = new int[digits.length+1];
            digits[0] = 0;
            newDigits[0] = 1;
            for(int i = 1; i < newDigits.length; i++)
                newDigits[i] = digits[i-1];
            return newDigits;
        }
        return digits;
    }
}