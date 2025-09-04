/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 找到本組的起點與終點
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break; // 不足 k 個就結束
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 斷開本組，反轉
            kth.next = null;
            ListNode reversed = reverse(groupStart);

            // 接回反轉後的部分
            prevGroupEnd.next = reversed;
            groupStart.next = nextGroupStart;

            // 移動 prevGroupEnd 到本組最後
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // 取得從 node 開始後的第 k 個節點
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    // 反轉一段鏈結串列
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
