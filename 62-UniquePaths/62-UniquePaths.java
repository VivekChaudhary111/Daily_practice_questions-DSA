// Last updated: 10/4/2025, 11:17:28 PM
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1); // firstly row ko 1 fill kiya beacause its each element has one path like right->right,.so on
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;  // similarly first column ko fill kiya, due to only 1 path to each element like down->down,.so on
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}