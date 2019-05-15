package stringmatching;

public class KMP {

    private static int kmpMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = p.length();
        int[] nexts = getNexts(p);
        while (i < m) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = nexts[j - 1] + 1;
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
            i++;
        }
        return -1;
    }

    private static int[] getNexts(String pattern) {
        int[] nexts = new int[pattern.length()];
        nexts[0] = -1;
        for (int i = 1, len = nexts.length; i < len - 1; i++) {
            int j = nexts[i - 1];
            while (j != -1 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                j = nexts[j];
            }
            if (pattern.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            nexts[i] = j;
        }
        return nexts;
    }

    public static void main(String[] args) {
        System.out.println(kmpMatch("ababasafdjiwfsfkadkfkw", "kad"));
    }
}
