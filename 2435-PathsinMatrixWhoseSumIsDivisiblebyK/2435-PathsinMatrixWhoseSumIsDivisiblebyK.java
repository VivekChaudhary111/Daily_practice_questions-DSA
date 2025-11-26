// Last updated: 11/26/2025, 7:46:59 AM
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int[][] arr : dp){
            for(int[] a : arr){
                Arrays.fill(a, -1);
            }
        }
        return dfs(grid, k, 0, 0, 0, dp);
    }
    public static int dfs(int[][] grid, int k, int cr, int cc, int sum, int[][][] dp){
        if(cr == grid.length || cc == grid[0].length){
            return 0;
        }
        sum += grid[cr][cc];
        sum %= k;
        if((cr == grid.length - 1 && cc == grid[0].length - 1) && sum == 0){
            return 1;
        }
        if(dp[cr][cc][sum] != -1){
            return dp[cr][cc][sum];
        }
        long count = 0;
        count += dfs(grid, k, cr + 1, cc, sum, dp);
        count += dfs(grid, k, cr, cc + 1, sum, dp);
        return dp[cr][cc][sum] = (int) count % 1000000007;
    }
}