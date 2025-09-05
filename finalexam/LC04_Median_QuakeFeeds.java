import java.io.*;

public class LC04_Median_QuakeFeeds {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();
        double[] A = new double[n];
        double[] B = new double[m];
        for (int i = 0; i < n; i++) A[i] = fs.nextDouble();
        for (int i = 0; i < m; i++) B[i] = fs.nextDouble();
        if (n > m) {
            double[] t = A; A = B; B = t;
            int tmp = n; n = m; m = tmp;
        }
        int totalLeft = (n + m + 1) / 2;
        int lo = 0, hi = n;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;
            int j = totalLeft - i;
            double Aleft = (i == 0) ? -1e18 : A[i - 1];
            double Aright = (i == n) ? 1e18 : A[i];
            double Bleft = (j == 0) ? -1e18 : B[j - 1];
            double Bright = (j == m) ? 1e18 : B[j];
            if (Aleft <= Bright && Bleft <= Aright) {
                if (((n + m) & 1) == 1) {
                    System.out.println(String.format(java.util.Locale.US, "%.1f", Math.max(Aleft, Bleft)));
                } else {
                    double x = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                    System.out.println(String.format(java.util.Locale.US, "%.1f", x));
                }
                return;
            } else if (Aleft > Bright) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= 32) if (c == -1) return null;
            do {
                sb.append((char) c);
                c = read();
            } while (c > 32);
            return sb.toString();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
    }
}
