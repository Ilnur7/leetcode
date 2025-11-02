package besttime;

public class BestTimeBuySellStock121 {
    public static void main(String[] args) {
        int[] arr = new int[] {7,1,5,3,6,4};
        maxProfit(arr);
    }

    public static int maxProfit(int[] prices) {
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                buy[i] = min;
            }
        }


        for (int i = 0; i < prices.length; i++) {
            int max = prices[i];
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > max) {
                    max = prices[i];
                }
            }
            sell[i] = max;
        }

        int res = -1;
        for (int i = 0; i < prices.length; i++) {
            int diff = buy[i] - sell[i];
            if (diff > res) {
                res = diff;
            }
        }
        return res;
    }
}
