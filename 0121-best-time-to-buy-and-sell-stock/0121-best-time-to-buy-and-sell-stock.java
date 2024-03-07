class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length, profit=0;
        int preMax = prices[size-1];
        for(int i=size-2; i>=0; i--){
            int currPrice = prices[i];
            if(currPrice>preMax){
                preMax = currPrice;
            }
            profit = profit>(preMax-currPrice) ? profit:(preMax-currPrice);
        }
        return profit;
    }
}