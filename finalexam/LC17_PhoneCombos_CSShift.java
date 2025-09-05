import java.io.*;
import java.util.*;

public class LC17_PhoneCombos_CSShift {
    static String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String digits = br.readLine();
        if (digits == null || digits.isEmpty()) {
            System.out.println();
            return;
        }
        dfs(digits, 0, new StringBuilder());
        for (String s : res) System.out.println(s);
    }

    static void dfs(String digits, int idx, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            dfs(digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
