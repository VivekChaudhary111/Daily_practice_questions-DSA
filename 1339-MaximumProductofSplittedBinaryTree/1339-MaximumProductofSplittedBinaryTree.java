// Last updated: 1/7/2026, 8:25:42 PM
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
17    static long ans = 0;
18    public int maxProduct(TreeNode root) {
19        ans = 0;
20        long total = sum(root);
21        long prod = sum2(root, total);
22        return (int) (ans%1000000007);
23    }
24    public long sum2(TreeNode root, long total){
25        if(root == null){
26            return 0;
27        }
28        long left = sum2(root.left, total);
29        long right = sum2(root.right, total);
30        long currtotal = left + right + root.val;
31        ans = Math.max(ans, currtotal * (total - currtotal));
32        return currtotal;
33    }
34    public long sum(TreeNode root){
35        if(root == null){
36            return 0;
37        }
38        long left = sum(root.left);
39        long right = sum(root.right);
40        return left + right + root.val;
41    }
42}