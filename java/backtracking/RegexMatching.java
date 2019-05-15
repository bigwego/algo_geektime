package backtracking;

public class RegexMatching {

    private static boolean match(String str, String pattern) {
        return match(str, 0, pattern, 0, str.length(), pattern.length());
    }

    private static boolean match(String str, int i, String pattern, int j, int m, int n) {
        if (i == m && j == n) {
            return true;
        } else if (i == m || j == n) {
            return false;
        }
        if (pattern.charAt(j) == '*') {
            for (int k = i; k <= m; k++) {
                if (match(str, k, pattern, j + 1, m, n)) {
                    return true;
                }
            }
        } else if (pattern.charAt(j) == '?') {
            return match(str, i, pattern, j + 1, m, n) || match(str, i + 1, pattern, j + 1, m, n);
        } else if (str.charAt(i) == str.charAt(j)) {
            return match(str, i + 1, pattern, j + 1, m, n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("abcdefg", "ab*d?fg"));
    }


}
