public class Knapsack {
    int knapsack(int[] w, int[] v, int n, int m) {
        if (n <= 0 || m <= 0) {
            return 0;
        }

        int[][] dp = new int[n+1][m+1];
        for (int j=0; j<=m; j++) {
            dp[0][j] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (w[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};

        int m = 50;
        int n = val.length;

        System.out.println(knapsack.knapsack(wt, val, n, m));
    }
}
