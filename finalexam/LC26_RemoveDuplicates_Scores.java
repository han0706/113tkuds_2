import java.io.*;
import java.util.*;

public class LC26_RemoveDuplicates_Scores {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) nums[idx++] = nums[i];
        }
        return idx;
    }
}
