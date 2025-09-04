import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 當長度到達 2*n，就形成一個合法組合
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 只要還有左括號可以加
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // 只要右括號數量 < 左括號數量，就能加右括號
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
