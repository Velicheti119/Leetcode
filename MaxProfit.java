// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = prices[0];
        for(int price : prices) {
            if(price < lowestPrice) {
                lowestPrice = price;
            } else {
                int currProfit = price - lowestPrice;
                profit = Math.max(profit, currProfit);
            }
        }
        return profit;
    }
}
