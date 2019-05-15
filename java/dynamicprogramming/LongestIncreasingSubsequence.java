package dynamicprogramming;

public class LongestIncreasingSubsequence {

    private static int longestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{ 2, 9, 3, 6, 5, 1, 7, 8, 9 }));
    }
}
