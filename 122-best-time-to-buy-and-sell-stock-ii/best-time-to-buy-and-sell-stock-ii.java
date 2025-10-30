class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 0;
        int max = 0;
        for(int i= 0; i<n-1; i++){
            if(prices[buy] > prices[i+1]){
                buy = i+1;
            }
            if(prices[buy] < prices[i+1]){
                max = max + (prices[i+1] - prices[buy]);
                buy = i+1;
            }
        }
        return max;
    }
}