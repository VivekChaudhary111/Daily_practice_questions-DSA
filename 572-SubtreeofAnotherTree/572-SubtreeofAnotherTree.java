// Last updated: 3/16/2026, 3:11:45 PM
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
17    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
18        if(root == null){
19            return false;
20        }
21        boolean flag = false;
22        if(root.val == subRoot.val){
23            flag = solve(root, subRoot);
24        }
25        return flag || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
26
27    }
28    boolean solve(TreeNode root1, TreeNode root2){
29        if(root1 == null && root2 == null){
30            return true;
31        }
32        if(root1 == null || root2 == null){
33            return false;
34        }
35        if(root1.val != root2.val) return false;
36        return solve(root1.left, root2.left) && solve(root1.right, root2.right);
37    }
38}