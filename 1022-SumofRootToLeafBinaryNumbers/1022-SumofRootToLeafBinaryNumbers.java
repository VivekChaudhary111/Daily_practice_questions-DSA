// Last updated: 2/25/2026, 2:11:04 AM
1class Solution {
2    public int sumRootToLeaf(TreeNode root) {
3        int[] res = { 0 };
4        dfs(root, 0, res);
5        return res[0];
6    }
7    public void dfs(TreeNode root, int currSum, int[] res) {
8        if(root == null) return;
9        
10        currSum = (currSum << 1) + root.val;
11        if(root.left == null && root.right == null) {
12            res[0] += currSum;
13            return; // end curr traversal and move to next possible path.
14        }
15
16        dfs(root.left, currSum, res);
17        dfs(root.right, currSum, res);
18    }
19}