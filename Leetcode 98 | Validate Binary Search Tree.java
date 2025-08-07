/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class BstPair{
		boolean isBst = true;
		Long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
	}
	public boolean isValidBST(TreeNode root) {
        return ValidBST(root).isBst;
		}
		public BstPair ValidBST(TreeNode root) {
            if(root == null) {
                return new BstPair();
            }
			BstPair lbp = ValidBST(root.left);
			BstPair rbp = ValidBST(root.right);
			BstPair sbp = new BstPair();
			sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
			sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
			sbp.isBst = lbp.isBst && rbp.isBst && lbp.max < root.val && rbp.min > root.val;
			return sbp;
		}
		
}
