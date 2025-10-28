// Last updated: 10/28/2025, 4:31:35 PM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode dummy = head;
        while(dummy != null){
            len++;
            dummy = dummy.next;
        }
        int pos = len - n;
        dummy = head;
        for(int i = 0; i < pos-1; i++){
            dummy = dummy.next;
        }
        if(pos != 0){
            dummy.next = dummy.next.next;
            return head;
        }else{
            return head.next;
        }
    }
}