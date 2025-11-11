// Last updated: 11/12/2025, 1:29:02 AM
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        for(int[][] a: dp){
            for(int[] b: a) {
                Arrays.fill(b, -1);
            }
        }
        return getLen(strs, m, n, 0, dp);
    }
    public static int getLen(String[] strs, int m, int n, int idx, int[][][] dp){
        if(idx == strs.length){
            return 0;
        }
        if(dp[m][n][idx] != -1){
            return dp[m][n][idx];
        }
        // pick
        int cz = 0, co = 0;
        String str = strs[idx];
        for(char ch : str.toCharArray()){
            if(ch=='0') cz++;
            else co++;
        }
        int ans1 = 0;
        if(m - cz >= 0 && n - co >= 0){
            ans1 = 1 + getLen(strs, m - cz, n- co, idx + 1, dp);
        }
        // not pick
        int ans2 = getLen(strs, m, n, idx + 1, dp);
        return dp[m][n][idx] = Math.max(ans1, ans2);
    }
}