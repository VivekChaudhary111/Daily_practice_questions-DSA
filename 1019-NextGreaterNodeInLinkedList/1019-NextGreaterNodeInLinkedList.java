// Last updated: 2/3/2026, 12:24:19 PM
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
12    public int[] nextLargerNodes(ListNode head) {
13        int size  = 0;
14        ListNode temp = head;
15        while(temp != null){
16            size++;
17            temp = temp.next;
18        }
19        int i = 0;
20        int[] ans = new int[size];
21        temp = head;
22        while(temp != null){
23            ans[i++] = temp.val;
24            temp = temp.next;
25        }
26        Stack<Integer> st = new Stack<>();
27        i = 0;
28        while(i < size){
29            while(!st.isEmpty() && ans[i] > ans[st.peek()]){
30                ans[st.pop()] = ans[i];
31            }
32            st.push(i++);
33        }
34        while(!st.isEmpty()){
35            ans[st.pop()] = 0;
36        }
37        return ans;
38    }
39}