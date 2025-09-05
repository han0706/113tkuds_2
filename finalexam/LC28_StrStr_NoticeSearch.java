import java.io.*;

public class LC28_StrStr_NoticeSearch {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String haystack = br.readLine();
        String needle = br.readLine();
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        return haystack.indexOf(needle);
    }
}
