import java.io.*;
import java.util.*;

public class LC25_ReverseKGroup_Shifts {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ListNode head = build(st);
        int k = Integer.parseInt(br.readLine());
        ListNode res = reverseKGroup(head, k);
        print(res);
    }

    static ListNode build(StringTokenizer st) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (st.hasMoreTokens()) {
            cur.next = new ListNode(Integer.parseInt(st.nextToken()));
            cur = cur.next;
        }
        return dummy.next;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) System.out.print(" ");
        }
        System.out.println();
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (true) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
