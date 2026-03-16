// Last updated: 3/16/2026, 2:51:26 PM
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
17    int min = Integer.MAX_VALUE;
18    int prev = Integer.MIN_VALUE;
19    public int getMinimumDifference(TreeNode root) {
20        ans(root);
21        return min;
22    }
23    void ans(TreeNode root){
24        if(root == null){
25            return;
26        }
27        ans(root.left);
28        if(prev != Integer.MIN_VALUE){
29            min = Math.min(min, root.val - prev);
30        }
31        prev = root.val;
32        ans(root.right);
33    }
34}