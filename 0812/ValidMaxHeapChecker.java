public class ValidMaxHeapChecker {
    public static boolean check(int[] arr) {
        for (int i = 0; i <= (arr.length - 2) / 2; i++) {
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < arr.length && arr[i] < arr[l]) {
                System.out.println("false (索引" + l + "的" + arr[l] + "大於父節點" + arr[i] + ")");
                return false;
            }
            if (r < arr.length && arr[i] < arr[r]) {
                System.out.println("false (索引" + r + "的" + arr[r] + "大於父節點" + arr[i] + ")");
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(check(new int[]{100,90,80,70,60,75,65}));
        System.out.println(check(new int[]{100,90,80,95,60,75,65}));
        System.out.println(check(new int[]{50}));
        System.out.println(check(new int[]{}));
    }
}
