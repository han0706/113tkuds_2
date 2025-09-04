class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 排序方便跳過重複
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // 跳過重複
            if (candidates[i] > target) break; // 剪枝
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, res); // 每個數字只能用一次
            path.remove(path.size() - 1); // 回溯
        }
    }
}
