package dynamicprogramming;

import java.util.Arrays;

public class MinimumCoins {

    private static int minimumCoins(int[] coins, int money) {
        int m = coins.length;
        int[][] dp = new int[m][money + 1];
        for (int[] row : dp) {
            Arrays.fill(row, money + 1);
        }
        dp[0][0] = 0;
        for (int i = coins[0]; i <= money; i++) {
            dp[0][i] = Math.min(dp[0][i], 1 + dp[0][i - coins[0]]);
        }
        for (int x = 0; x <= money; x++) {
            System.out.print(dp[0][x] + " ");
        }
        System.out.println();
        for (int i = 1; i < m; i++) {
            for (int j = coins[i]; j <= money; j++) {
                dp[i][j] = Math.min(dp[i][j],
                        Math.min(1 + dp[i][j - coins[i]], 1 + dp[i - 1][j - coins[i]]));
            }
            for (int x = 0; x <= money; x++) {
                System.out.print(dp[i][x] + " ");
            }
            System.out.println();
        }
        return dp[m - 1][money] == money + 1 ? -1 : dp[m - 1][money];
    }

    private static int minimumCoins2(int[] coins, int money) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, money + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= money; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[money] == money + 1 ? -1 : dp[money];
    }

    public static void main(String[] args) {
        System.out.println(minimumCoins(new int[]{ 2, 3, 4 }, 9));
    }
}
