import java.util.*;

public class SelectionSortImplementation {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int compare = 0, swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                compare++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            if (i != minIdx) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                swap++;
            }
            System.out.println("第" + (i + 1) + "輪: " + Arrays.toString(arr));
        }
        System.out.println("比較次數: " + compare);
        System.out.println("交換次數: " + swap);
    }
}
