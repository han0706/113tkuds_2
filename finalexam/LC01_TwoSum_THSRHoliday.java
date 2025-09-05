import java.io.*;
import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
        Map<Long, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long need = target - a[i];
            if (seen.containsKey(need)) {
                System.out.println(seen.get(need) + " " + i);
                return;
            }
            if (!seen.containsKey(a[i])) seen.put(a[i], i);
        }
        System.out.println("-1 -1");
    }
}
