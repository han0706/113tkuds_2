import java.io.*;
import java.util.*;

public class LC27_RemoveElement_Recycle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine()); // 要刪除的值
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
        int[] nums = list.stream().mapToInt(i -> i).toArray();

        int newLen = removeElement(nums, val);
        for (int i = 0; i < newLen; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    private static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int num : nums) {
            if (num != val) nums[idx++] = num;
        }
        return idx;
    }
}
