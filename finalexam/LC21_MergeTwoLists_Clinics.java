import java.io.*;
import java.util.*;

public class LC21_MergeTwoLists_Clinics {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ListNode l1 = build(st1), l2 = build(st2);
        ListNode res = mergeTwoLists(l1, l2);
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

    static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) { cur.next = a; a = a.next; }
            else { cur.next = b; b = b.next; }
            cur = cur.next;
        }
        cur.next = (a != null ? a : b);
        return dummy.next;
    }
}
