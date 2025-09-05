import java.io.*;
import java.util.*;

public class LC11_MaxArea_FuelHoliday {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) h[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = n - 1;
        long ans = 0;
        while (l < r) {
            long area = (long) (r - l) * Math.min(h[l], h[r]);
            ans = Math.max(ans, area);
            if (h[l] < h[r]) l++;
            else r--;
        }
        System.out.println(ans);
    }
}
