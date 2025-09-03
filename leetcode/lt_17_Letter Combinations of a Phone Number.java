import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); // 回溯
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(sol.letterCombinations("2"));  // [a, b, c]
        System.out.println(sol.letterCombinations(""));   // []
    }
}
