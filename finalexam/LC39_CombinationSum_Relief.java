import java.io.*;
import java.util.*;

public class LC39_CombinationSum_Relief {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
        int[] candidates = list.stream().mapToInt(i -> i).toArray();

        List<List<Integer>> res = combinationSum(candidates, target);
        for (List<Integer> comb : res) {
            for (int i = 0; i < comb.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(comb.get(i));
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, int remain, int start, List<Integer> comb, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) break;
            comb.add(nums[i]);
            backtrack(nums, remain - nums[i], i, comb, res); // 可以重複選
            comb.remove(comb.size() - 1);
        }
    }
}
