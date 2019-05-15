package backtracking;

public class ZeroOnePack {

    private int max = Integer.MIN_VALUE;

    public void getMax(int weight, int[] weights) {
        getMax(weight, weights, weights.length, 0, 0);
    }

    private void getMax(int weight, int[] weights, int len, int idx, int currWeight) {
        if (idx == len) {
            max = Math.max(max, currWeight);
            return;
        }
        getMax(weight, weights, len, idx + 1, currWeight);
        if (weight >= weights[idx]) {
            getMax(weight - weights[idx], weights,
                    len, idx + 1, currWeight + weights[idx]);
        }
    }
}
