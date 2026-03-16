// Last updated: 3/16/2026, 2:12:45 PM
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
17    public int minDepth(TreeNode root) {
18        if(root == null) return 0;
19        int a = minDepth(root.left);
20        int b = minDepth(root.right);
21        if(a == 0 && b != 0) return b + 1; 
22        if(a != 0 && b == 0) return a + 1; 
23        return Math.min(a, b)  + 1;
24    }
25}