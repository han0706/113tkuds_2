import java.io.*;
import java.util.*;

public class LC19_RemoveNth_Node_Clinic {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(Integer.parseInt(st.nextToken()));
            cur = cur.next;
        }
        int k = Integer.parseInt(br.readLine());
        ListNode head = removeNthFromEnd(dummy.next, k);
        printList(head);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static void printList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < vals.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(vals.get(i));
        }
        System.out.println();
    }
}
