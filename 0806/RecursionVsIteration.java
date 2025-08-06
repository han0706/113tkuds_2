public class RecursionVsIteration {
    public static int binomialRec(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialRec(n - 1, k - 1) + binomialRec(n - 1, k);
    }

    public static int binomialIter(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= Math.min(i, k); j++)
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        return dp[n][k];
    }

    public static int productRec(int[] arr, int i) {
        if (i == arr.length) return 1;
        return arr[i] * productRec(arr, i + 1);
    }

    public static int productIter(int[] arr) {
        int prod = 1;
        for (int x : arr) prod *= x;
        return prod;
    }

    public static int countVowelsRec(String s, int i) {
        if (i == s.length()) return 0;
        char c = Character.toLowerCase(s.charAt(i));
        return ((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0) + countVowelsRec(s, i + 1);
    }

    public static int countVowelsIter(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray())
            if ("aeiou".indexOf(c) != -1) count++;
        return count;
    }

    public static boolean isBalanced(String s) {
        return checkBalance(s, 0, 0);
    }

    private static boolean checkBalance(String s, int i, int balance) {
        if (balance < 0) return false;
