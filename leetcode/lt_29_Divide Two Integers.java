class Solution {
    public int divide(int dividend, int divisor) {
        // 特殊情況：溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 符號判斷
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // 轉成 long 避免 overflow
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        int result = 0;

        while (ldividend >= ldivisor) {
            long temp = ldivisor, multiple = 1;
            // 用位移加速
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
