
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            minPrice = Math.min(minPrice, price);

           
            int gain = 0;

            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    gain++;
                }
            }

           
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j],
                                 dp[j - price] + gain);
            }
        }

        int ans = 0;

       
        for (int j = 0; j <= budget; j++) {
            int total = dp[j] + (budget - j) / minPrice;
            ans = Math.max(ans, total);
        }

        return ans;
    }
}
