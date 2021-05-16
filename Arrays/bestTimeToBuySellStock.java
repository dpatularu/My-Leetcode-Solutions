/*
122. Best Time to Buy and Sell Stock II
*/

class Solution {
    //This keeps track of the lowest buy price and sells at the highest sell price.
    public int myMaxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[i-1]){
                maxProfit += prices[i-1] - buyPrice;
                buyPrice = prices[i];
            }
        }
        //Sometimes the array will end before it finds the optimal sell point. This checks if it's worth selling at the end
        if(prices[prices.length - 1] - buyPrice > 0) maxProfit += prices[prices.length - 1] - buyPrice;
        return maxProfit;
    }
    //This is Leetcode's solution. This accumulates unrealized profit whenever there is any gain. 
    //Much cleaner and something to keep in mind
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}