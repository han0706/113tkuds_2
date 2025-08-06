import java.util.*;

public class NumberArrayProcessor {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 1, 5};
        Set<Integer> set = new LinkedHashSet<>();
        for (int n : arr) set.add(n);
        System.out.println("移除重複: " + set);
        int[] sorted1 = {1, 3, 5};
        int[] sorted2 = {2, 4, 6};
        int[] merged = new int[sorted1.length + sorted2.length];
        int i = 0, j = 0, k = 0;
        while (i < sorted1.length && j < sorted2.length)
            merged[k++] = sorted1[i] < sorted2[j] ? sorted1[i++] : sorted2[j++];
        while (i < sorted1.length) merged[k++] = sorted1[i++];
        while (j < sorted2.length) merged[k++] = sorted2[j++];
        System.out.println("合併排序: " + Arrays.toString(merged));
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) freq.put(n, freq.getOrDefault(n, 0) + 1);
        int maxFreq = 0, mostFreq = arr[0];
        for (int n : freq.keySet()) {
            if (freq.get(n) > maxFreq) {
                maxFreq = freq.get(n);
                mostFreq = n;
            }
        }
        System.out.println("最高頻率: " + mostFreq);
        int total = 0, half = Arrays.stream(arr).sum() / 2;
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int n : arr) {
            if (total + n <= half) {
                left.add(n);
                total += n;
            } else right.add(n);
        }
        System.out.println("子陣列1: " + left);
        System.out.println("子陣列2: " + right);
    }
}
