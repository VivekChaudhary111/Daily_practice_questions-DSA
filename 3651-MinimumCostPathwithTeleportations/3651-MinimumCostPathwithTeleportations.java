// Last updated: 1/29/2026, 4:24:59 AM
1class Solution {
2    public int minCost(int[][] grid, int k) {
3        int n = grid.length, m = grid[0].length;
4        int INF = (int)1e9;
5        int[][][] dp = new int[n][m][k+1];
6        
7        // Initialize DP with infinity
8        for(int i=0; i<n; i++)
9            for(int j=0; j<m; j++)
10                Arrays.fill(dp[i][j], INF);
11        
12        // Create sorted list of all cells by their grid value
13        List<int[]> sorted = new ArrayList<>();
14        for(int i=0; i<n; i++)
15            for(int j=0; j<m; j++)
16                sorted.add(new int[]{i, j});
17        sorted.sort((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
18        
19        // Base case: destination cost = 0 for all t
20        for(int t=0; t<=k; t++)
21            dp[n-1][m-1][t] = 0;
22        
23        // Process DP
24        for(int t=0; t<=k; t++){
25            int[] prefixMin = null;
26            if(t > 0){
27                // Precompute prefix minima for teleportation
28                prefixMin = new int[n*m];
29                int idx = 0;
30                for(int[] cell : sorted){
31                    int x = cell[0], y = cell[1];
32                    prefixMin[idx] = dp[x][y][t-1];
33                    if(idx > 0) 
34                        prefixMin[idx] = Math.min(prefixMin[idx], prefixMin[idx-1]);
35                    idx++;
36                }
37            }
38            
39            // Process cells in reverse order
40            for(int i=n-1; i>=0; i--){
41                for(int j=m-1; j>=0; j--){
42                    if(i==n-1 && j==m-1) continue;
43                    
44                    // Normal moves
45                    if(j+1 < m)
46                        dp[i][j][t] = Math.min(dp[i][j][t],
47                                              grid[i][j+1] + dp[i][j+1][t]);
48                    if(i+1 < n)
49                        dp[i][j][t] = Math.min(dp[i][j][t],
50                                              grid[i+1][j] + dp[i+1][j][t]);
51                    
52                    // Teleportation using prefix minima
53                    if(t > 0){
54                        // Binary search for last cell with value ≤ grid[i][j]
55                        int pos = lastLessEqual(sorted, grid, grid[i][j]);
56                        if(pos >= 0)
57                            dp[i][j][t] = Math.min(dp[i][j][t], prefixMin[pos]);
58                    }
59                }
60            }
61        }
62        return dp[0][0][k];
63    }
64    
65    // Binary search to find last index with value ≤ target
66    private int lastLessEqual(List<int[]> cells, int[][] grid, int target){
67        int left = 0, right = cells.size()-1, ans = -1;
68        while(left <= right){
69            int mid = left + (right-left)/2;
70            int[] cell = cells.get(mid);
71            if(grid[cell[0]][cell[1]] <= target){
72                ans = mid;
73                left = mid + 1; // Try for larger values
74            } else {
75                right = mid - 1;
76            }
77        }
78        return ans;
79    }
80}