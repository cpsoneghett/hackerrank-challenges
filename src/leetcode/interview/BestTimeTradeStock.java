package leetcode.interview;

public class BestTimeTradeStock {

    public static int maxProfit(int[] prices) {

        int profits = 0, minValIndex = 0;
        int lowerValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowerValue) {
                lowerValue = prices[i];
                minValIndex = i;
            }
        }

        for (int i = minValIndex; i < prices.length; i++) {
            int aux = prices[i] - lowerValue;

            if (aux > profits)
                profits = aux;
        }

        return profits;
    }

    public static int maxProfitOptimal(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentProfit = currentPrice - minPrice;

            if(currentProfit > maxProfit)
                maxProfit = currentProfit;

            if(currentPrice < minPrice)
                minPrice = currentPrice;
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {2, 4, 1};
        int[] prices3 = {3, 2, 6, 5, 0, 3};

        System.out.println(maxProfitOptimal(prices));
    }
}
