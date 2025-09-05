import java.io.*;
import java.util.*;

public class LC24_SwapPairs_Shifts {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ListNode head = build(st);
        ListNode res = swapPairs(head);
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

    static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode a = cur.next;
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            cur.next = b;
            cur = a;
        }
        return dummy.next;
    }
}
