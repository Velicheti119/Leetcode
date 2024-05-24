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
    public ListNode reverseList(ListNode head) {

        ListNode first = head;
        ListNode prev = null;
        ListNode curr = null;
        while(first != null) {
            curr = first.next;
            first.next = prev;
            prev = first;
            first = curr;
        }

        return prev;
    }
}
