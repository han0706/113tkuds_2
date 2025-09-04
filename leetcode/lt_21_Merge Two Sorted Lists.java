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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 建立虛擬頭節點，方便操作
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 當兩個串列都還有節點時，逐一比較
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 如果還有剩餘節點，直接接上
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // 回傳合併後的串列 (跳過 dummy)
        return dummy.next;
    }
}
