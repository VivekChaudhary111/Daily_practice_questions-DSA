// Last updated: 1/5/2026, 10:36:47 PM
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int m = dungeon.length, n = dungeon[0].length;
4        int[][] dp = new int[m][n];
5        for(int[] a: dp){
6            Arrays.fill(a, 0);
7        }
8        dp[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 1 : Math.abs(dungeon[m-1][n-1]) + 1;
9        for(int i = m-1; i >= 0; i--){
10            for(int j = n-1; j >= 0; j--){
11                if(i == m-1 && j == n-1) continue;
12                int down = i+1 < m ? dp[i+1][j]: Integer.MAX_VALUE;
13                int right = j+1 < n ? dp[i][j+1]: Integer.MAX_VALUE;
14                int res = Math.min(down, right) - dungeon[i][j];
15
16                dp[i][j] = res > 0 ? res : 1; 
17            }
18        }
19        return Math.abs(dp[0][0]);
20    }
21}