// Last updated: 3/16/2026, 2:03:38 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return getBST(nums, 0, nums.length - 1);
19    }
20    public static TreeNode getBST(int[] nums, int lo, int hi){
21        if(lo > hi) return null;
22        int mid = (lo + hi) / 2;
23        TreeNode root = new TreeNode(nums[mid]);
24        root.left = getBST(nums, lo, mid - 1);
25        root.right = getBST(nums, mid + 1, hi);
26        return root;
27    }
28}