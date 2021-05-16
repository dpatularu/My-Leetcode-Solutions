/*
38. Count and Say
*/

class Solution {
    public String countAndSay(int n) {
        String num = "1";
        for(int i = 1; i < n; i++){
            num = countAndSayString(num);
        }
        return num;
    }
    
    public String countAndSayString(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;
        while(i < s.length()){
           char numCounted = s.charAt(i);
            while(i < s.length() && s.charAt(i) == numCounted){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(numCounted);
            count = 0;
        }
        return sb.toString();
    }
}