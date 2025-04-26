package leetcode.interview.medium;

public class BestTimeTradeStockII {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int start = prices[0];

        for (int i = 1; i < prices.length; i++) {

            if(prices[i] > start)
                maxProfit += (prices[i] - start);

            start = prices[i];
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {2, 4, 1};
        int[] prices3 = {3, 2, 6, 5, 0, 3};

        System.out.println(maxProfit(prices));
    }
}
