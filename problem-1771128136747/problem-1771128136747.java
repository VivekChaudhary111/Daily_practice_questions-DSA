// Last updated: 2/15/2026, 9:32:16 AM
1class Solution {
2    public int almostPalindromic(String s) {
3        int n = s.length();
4        boolean[][] isPal = new boolean[n][n];
5        boolean[][] dp = new boolean[n][n];
6        int maxLen = 0;
7        for(int len = 1; len <= n; len++){
8            for(int i = 0; i <= n - len; i++){
9                int j = i + len -1;
10                if(len == 1){
11                    isPal[i][j] = true;
12                }else if(len == 2){
13                    isPal[i][j] = (s.charAt(i) == s.charAt(j));
14                }else{
15                    isPal[i][j] = (s.charAt(i) == s.charAt(j) && isPal[i+1][j-1]);
16                    
17                }
18            }
19        }
20        for(int i = 0; i < n; i++){
21            dp[i][i] = true;
22        }
23        for(int len = 2; len <= n; len++){
24            for(int i = 0; i <= n - len; i++){
25                int j = i + len - 1;
26                boolean rleft = isPal[i + 1][j];
27                boolean rright = isPal[i][j-1];
28                boolean matchE = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
29                if(rleft || rright || matchE){
30                    dp[i][j] = true;
31                    maxLen = len;
32                }
33            }
34        }
35        return maxLen;
36    }
37}