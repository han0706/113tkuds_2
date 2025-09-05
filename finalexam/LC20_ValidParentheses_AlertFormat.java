import java.io.*;
import java.util.*;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) s = "";
        Deque<Character> st = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (st.isEmpty() || st.peek() != map.get(c)) {
                    System.out.println("false");
                    return;
                }
                st.pop();
            } else {
                st.push(c);
            }
        }
        System.out.println(st.isEmpty() ? "true" : "false");
    }
}
