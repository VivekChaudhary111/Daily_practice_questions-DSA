// Last updated: 9/25/2025, 11:32:39 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i = 0; i < triangle.size(); i++) {
			Arrays.fill(dp[i], 2000000+1);
		}
        return minSum(triangle, 0, 0, dp);
    }
    public int minSum(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(col == triangle.get(row).size()) {
			return Integer.MAX_VALUE;
		}
		if(row == triangle.size() - 1) {
			return triangle.get(row).get(col);
		}
        if(dp[row][col] != 2000000+1){
            return dp[row][col];
        }
        int l = minSum(triangle, row+1, col, dp);
        int r = minSum(triangle, row+1, col+1, dp);
        return dp[row][col] = Math.min(l, r) + triangle.get(row).get(col);
    }
}