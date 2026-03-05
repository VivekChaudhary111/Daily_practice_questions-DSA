// Last updated: 3/5/2026, 2:11:47 PM
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+2];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int one=dp[i+1]+cost[i];
            int two=dp[i+2]+cost[i];
            dp[i]=Math.min(one,two);

        }
        return Math.min(dp[0],dp[1]);
        
    }
    
}