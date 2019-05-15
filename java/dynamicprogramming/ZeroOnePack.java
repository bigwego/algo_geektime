package dynamicprogramming;

public class ZeroOnePack {

    private static int maxWeight(int[] weights, int maxWeight) {
        int m = weights.length;
        int[][] dp = new int[m][maxWeight + 1];
        dp[0][0] = 1;
        dp[0][weights[0]] = weights[0] <= maxWeight ? 1 : 0;
        for (int i = 1; i < m; i++) {
            for (int j = weights[i]; j <= maxWeight; j++) {
                dp[i][j] = (dp[i - 1][j] == 1 || dp[i - 1][j - weights[i]] == 1) ? 1 : 0;
            }
        }
        for (int i = maxWeight; i > -1; i--) {
            if (dp[m - 1][i] == 1) {
                return i;
            }
        }
        return 0;
    }

    private static int maxWeight2(int[] weights, int maxWeight) {
        int[] dp = new int[maxWeight + 1];
        dp[0] = 1;
        for (int weight : weights) {
            for (int i = maxWeight; i >= weight; i--) {
                if (dp[i] == 1) {
                    continue;
                }
                if (dp[i - weight] == 1) {
                    dp[i] = 1;
                }
            }
        }
        for (int i = maxWeight; i > -1; i--) {
            if (dp[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{ 1, 3, 5, 6 }, 13));
    }
}
