class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int bestBuy =prices[0];
        int n = prices.length;

        // for calculating selling price in future starting for index1
        for(int i=1;i<n;i++){
            if(bestBuy < prices[i]){
                maxProfit= Math.max(maxProfit , prices[i]-bestBuy);
            }

            // calculating bestBuy if previous day buying price larger than today selling price then take the minimum
            bestBuy = Math.min(bestBuy, prices[i]);
        }
        return maxProfit;
        
    }
}