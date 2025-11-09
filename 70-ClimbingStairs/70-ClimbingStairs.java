// Last updated: 11/9/2025, 11:02:25 PM
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return count(n, dp);
        // dp[0] = 0; dp[1] = 1;
        // for(int i = 2; i < n+1; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

    }
    public int count(int n, int[] dp){
        if(n == 0) return 1;
        int ans = 0;
        if(dp[n] != 0){
            return dp[n];
        }
        ans +=  count(n-1, dp);
        if(n>1){
            ans += count(n-2, dp);
        }
        return dp[n] = ans;

    }
}