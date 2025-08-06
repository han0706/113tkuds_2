
public class AdvancedStringRecursion {
    public static void permute(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String rem = s.substring(0, i) + s.substring(i + 1);
            permute(rem, ans + s.charAt(i));
        }
    }

    public static boolean match(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*')
            return match(s, p.substring(2)) || (first && match(s.substring(1), p));
        else return first && match(s.substring(1), p.substring(1));
    }

    public static String removeDuplicates(String s) {
        if (s.length() <= 1) return s;
        if (s.charAt(0) == s.charAt(1)) return removeDuplicates(s.substring(1));
        return s.charAt(0) + removeDuplicates(s.substring(1));
    }

    public static void substrings(String s, String curr) {
        if (s.isEmpty()) {
            System.out.println(curr);
            return;
        }
        substrings(s.substring(1), curr + s.charAt(0));
        substrings(s.substring(1), curr);
    }

    public static void main(String[] args) {
        permute("abc", "");
        System.out.println(match("aab", "c*a*b"));
        System.out.println(removeDuplicates("aaabccdee"));
        substrings("abc", "");
    }
}
