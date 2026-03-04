// Last updated: 3/4/2026, 12:10:53 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length, n = mat[0].length;
4        boolean[] row = new boolean[m];
5        boolean[] col = new boolean[n];
6        for(int i = 0; i < m; i++){
7            int cnt = 0;
8            for(int j = 0; j < n; j++){
9                if(mat[i][j] == 1){
10                    cnt++;
11                    if(cnt > 1){
12                        row[i] = false;
13                        break;
14                    }
15                }
16            }
17            if(cnt == 1) row[i] = true;
18        }
19        for(int i = 0; i < n; i++){
20            int cnt = 0;
21            for(int j = 0; j < m; j++){
22                if(mat[j][i] == 1){
23                    cnt++;
24                    if(cnt > 1){
25                        col[i] = false;
26                        break;
27                    }
28                }
29            }
30            if(cnt == 1) col[i] = true;
31        }
32        int ans = 0;
33        for(int i = 0; i < m; i++){
34            for(int j = 0; j < n; j++){
35                if(mat[i][j] == 1 && row[i] && col[j]){
36                    ans++;
37                }
38            }
39        }
40        return ans;
41    }
42}