import java.io.*;
import java.util.*;

public class M01_BuildHeap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String type = br.readLine().trim();
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        boolean isMax = type.equalsIgnoreCase("max");
        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i, isMax);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(a[i]);
        }
        System.out.print(sb.toString());
    }
    static void heapify(int[] a, int n, int i, boolean isMax) {
        while (true) {
            int l = 2 * i + 1, r = 2 * i + 2, best = i;
            if (l < n && better(a[l], a[best], isMax)) best = l;
            if (r < n && better(a[r], a[best], isMax)) best = r;
            if (best == i) break;
            int tmp = a[i]; a[i] = a[best]; a[best] = tmp;
            i = best;
        }
    }
    static boolean better(int x, int y, boolean isMax) { return isMax ? x > y : x < y; }
}

/*
 * Time Complexity: O(n)
 * 說明：自底向上建堆，自最後一個非葉節點開始每個節點最多向下交換高度次，總成本為線性時間。
 */