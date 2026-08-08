import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};

        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res = res + prices[i] - prices[i - 1];
                System.out.println("Buy at: " + prices[i - 1] + ", Sell at: " + prices[i] + ", Current Profit: " + (prices[i] - prices[i - 1] + " Total profit: " + res));
            }
        }

        System.out.println("Total Profit: " + res);

        int totalProfit = 0, low = prices[0], buy = prices[0], sell = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int p : prices) {
            int curPft = p - low;

            if (curPft > totalProfit) {
                totalProfit = curPft;
                buy = low;
                sell = p;

                map.put("Buy", buy);
                map.put("Sell", sell);
                map.put("Profit", totalProfit);
            }

            low = Math.min(low, p);
        }
        System.out.println(map);
    }
}
