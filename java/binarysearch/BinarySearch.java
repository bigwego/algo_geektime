package binarysearch;

public class BinarySearch {

    private static int findFirstEqual(int[] a, int num) {
        int l = 0, r = a.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == num) {
                res = mid;
                r = mid - 1;
            } else if (a[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static int findFirstEqual2(int[] a, int num) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < num) {
                l = mid + 1;
            } else if (a[mid] > num) {
                r = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != num) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int findLastEqual(int[] a, int num) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < num) {
                l = mid + 1;
            } else if (a[mid] > num) {
                r = mid - 1;
            } else {
                if (mid == a.length - 1 || a[mid + 1] != num) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    private static int findFirstEqualOrLarger(int[] a, int num) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < num) {
                l = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] < num) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int findLastEqualOrLess(int[] a, int num) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > num) {
                r = mid - 1;
            } else {
                if (mid == a.length - 1 || a[mid + 1] > num) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int rotateArrayBinarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = (a[mid] < a[0] == target < a[0]) ?
                    a[mid] : target < a[0] ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (num == target) {
                return mid;
            } else if (num < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 5, 6, 8, 8, 8, 11, 18 };
        System.out.println(findLastEqualOrLess(a, 12));
    }
}
