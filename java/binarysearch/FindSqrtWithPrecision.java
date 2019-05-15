package binarysearch;

public class FindSqrtWithPrecision {

    private static double sqrt(double x, double precision) {
        if (x < 0) {
            return Double.NaN;
        }

        double l = 1, r = x;
        if (0 < x && x < 1) {
            l = x;
            r = 1;
        }

        while (r - l > precision) {
            double mid = l + (r - l) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l + (r - l) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(17, 0.000001));
    }
}
