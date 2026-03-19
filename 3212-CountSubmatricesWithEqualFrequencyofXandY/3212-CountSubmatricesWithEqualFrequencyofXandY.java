// Last updated: 3/19/2026, 1:06:24 PM
1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int n  = grid.length;
4        int m  = grid[0].length;
5        int[][][] cnt = new int[n+1][m+1][2];
6        for(int i = 0; i < n; i++){
7            for(int j = 0; j < m; j++){
8                cnt[i+1][j+1][0] = cnt[i+1][j][0];
9                cnt[i+1][j+1][1] = cnt[i+1][j][1];  
10                if(grid[i][j] == 'X'){
11                    cnt[i+1][j+1][0]++;
12                }
13                if(grid[i][j] == 'Y'){
14                    cnt[i+1][j+1][1]++;
15                }
16            }
17        }
18        for(int j = 1; j <= m; j++){
19            for(int i = 1; i <= n; i++){
20                cnt[i][j][0] += cnt[i-1][j][0];
21                cnt[i][j][1] += cnt[i-1][j][1];
22            }
23        }
24        int res = 0;
25        for(int i = 1; i <= n; i++){
26            for(int j = 1; j <= m; j++){
27                if(cnt[i][j][0] == cnt[i][j][1] && cnt[i][j][0] > 0) res++;
28            }
29        }
30        return res;
31    }
32}