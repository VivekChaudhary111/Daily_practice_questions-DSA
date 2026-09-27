// Last updated: 9/27/2026, 10:23:11 PM
1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int m = s1.length(), n = s2.length();
4        int[][] dp = new int[m + 1][n + 1];
5        for(int i = 1; i < m + 1; i++){
6            for(int j = 1; j < n + 1; j++){
7                if(s1.charAt(i-1) == s2.charAt(j-1))
8                    dp[i][j] = 1 + dp[i-1][j-1];
9                else
10                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
11            }
12        }
13        return dp[m][n];
14    }
15
16}