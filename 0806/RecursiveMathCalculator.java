public class RecursiveMathCalculator {
    public static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;
        return combination(n - 1, k - 1) + combination(n - 1, k);
    }

    public static int catalan(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++)
            res += catalan(i) * catalan(n - 1 - i);
        return res;
    }

    public static int hanoiMoves(int n) {
        if (n == 1) return 1;
        return 2 * hanoiMoves(n - 1) + 1;
    }

    public static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        return isPal(s, 0, s.length() - 1);
    }

    private static boolean isPal(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPal(s, l + 1, r - 1);
    }

    public static void main(String[] args) {
        System.out.println(combination(5, 2));
        System.out.println(catalan(4));
        System.out.println(hanoiMoves(3));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12345));
    }
}
