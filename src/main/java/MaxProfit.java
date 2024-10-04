public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int low = prices[0];

    for (int i = 0; i < prices.length; i++) {
        if (prices[i] < low) {
            low = prices[i];
        } else {
            maxProfit = Math.max(maxProfit, prices[0] - low);
        }
    }
    return maxProfit;
}

public int maxProfit2(int[] prices) {
    int low = prices[0];
    int hi = prices[0];
    int maxProfit = 0;
    int i = 0;
    int len = prices.length;
    while (i < len - 1) {
        while (i < len - 1 && prices[i] >= prices[i + 1]) i++;
        low = prices[i];
        while (i < len - 1 && prices[i] <= prices[i + 1]) i++;
        hi = prices[i];
        maxProfit += hi - low;
    }
    return maxProfit;
}