public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0, end = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
                start = i - 1;
                end = i;
            }
        }

        for (int diff = 2; diff < len; diff++) {
            for (int i = 0; i < len - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
