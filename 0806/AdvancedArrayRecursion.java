import java.util.*;

public class AdvancedArrayRecursion {
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r], i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
                i++;
            }
        }
        int t = arr[i]; arr[i] = arr[r]; arr[r] = t;
        return i;
    }

    public static int[] merge(int[] a, int[] b) {
        if (a.length == 0) return b;
        if (b.length == 0) return a;
        if (a[0] < b[0]) return mergeArrays(new int[]{a[0]}, merge(Arrays.copyOfRange(a, 1, a.length), b));
        else return mergeArrays(new int[]{b[0]}, merge(a, Arrays.copyOfRange(b, 1, b.length)));
    }

    private static int[] mergeArrays(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    public static int kthSmallest(int[] arr, int k, int l, int r) {
        if (l == r) return arr[l];
        int p = partition(arr, l, r);
        int count = p - l + 1;
        if (k == count) return arr[p];
        else if (k < count) return kthSmallest(arr, k, l, p - 1);
        else return kthSmallest(arr, k - count, p + 1, r);
    }

    public static boolean subsetSum(int[] arr, int i, int target) {
        if (target == 0) return true;
        if (i == arr.length) return false;
        return subsetSum(arr, i + 1, target) || subsetSum(arr, i + 1, target - arr[i]);
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 5, 2};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        int[] merged = merge(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(merged));
        int[] b = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(b, 3, 0, b.length - 1));
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 0, 9));
    }
}
