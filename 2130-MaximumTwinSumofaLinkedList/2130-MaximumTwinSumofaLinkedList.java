// Last updated: 6/14/2026, 11:05:18 PM
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
12    public int pairSum(ListNode head) {
13        ListNode slow = head;
14        ListNode fast  = head;
15        while(fast != null && fast.next != null){
16            slow = slow.next;
17            fast = fast.next.next;
18        }
19        Stack<ListNode> st = new Stack<>();
20        while(slow != null){
21            st.add(slow);
22            slow = slow.next;
23        }
24        int ans = Integer.MIN_VALUE;
25        while(!st.isEmpty()){
26            ans = Math.max(ans, st.pop().val + head.val);
27            head = head.next;
28        }
29        return ans;
30    }
31}