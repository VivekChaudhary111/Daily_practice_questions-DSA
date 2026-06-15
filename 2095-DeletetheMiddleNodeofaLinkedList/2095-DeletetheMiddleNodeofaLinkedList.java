// Last updated: 6/15/2026, 10:59:35 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteMiddle(ListNode head) {
13        if(head ==null || head.next == null) return null;
14        ListNode slow = head;
15        ListNode fast = head.next.next; // to get the slow at (mid - 1) node
16        while(fast != null && fast.next != null){
17            slow = slow.next;
18            fast = fast.next.next;
19        }
20        slow.next = slow.next.next;
21        return head;
22    }
23}