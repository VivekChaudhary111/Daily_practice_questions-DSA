// Last updated: 11/1/2025, 9:38:18 AM
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        ListNode dummy = new ListNode(0, head);
        ListNode ans = dummy;
        while(dummy.next != null){
            if(set.contains(dummy.next.val)){
                dummy.next = dummy.next.next;
            }else{
                dummy = dummy.next;
            }
        }
        return ans.next;
    }
}