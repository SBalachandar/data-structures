package arraysol;

public class StockBuySellProblem {

    public static void buySellMaxProfit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int buyPrice = arr[0];
        int sellPrice = arr[0];
        int profit = sellPrice - buyPrice;// 0
        // {12,14,20,18,16}

        for (int i = 1; i < arr.length; i++) {
            int price = arr[i];

            if (profit < (price - sellPrice)) {
                sellPrice = price;
                profit = sellPrice - buyPrice;
            }

        }

        System.out.println("buyPrice  " + buyPrice + " sellPrice " + sellPrice
                + " profit " + profit);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int min = prices[0]; // min so far
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        System.out.println("result " + result);
        return result;
    }

    public static int profit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    public static int buySellManyTimes(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit = profit + diff;
            }
        }
        return profit;
    }

    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (len < 2 || k <= 0)
            return 0;

        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {

                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);

                global[i][j] = Math.max(global[i - 1][j], local[i][j]);

            }
        }

        return global[prices.length - 1][k];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {12, 90, 93, 100};

        System.out.println("");
        // System.out.println( "max profit = " + profit(arr));
        // System.out.println( "buySellManyTimes profit = " +
        // buySellManyTimes(arr));

        System.out.println(" max profile " + maxProfit(2, arr));

    }

}
