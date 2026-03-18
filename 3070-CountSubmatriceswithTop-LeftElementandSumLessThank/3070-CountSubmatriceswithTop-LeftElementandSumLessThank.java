// Last updated: 3/18/2026, 4:04:59 PM
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int n=grid.length;
4        int m=grid[0].length;
5        for(int i=0;i<n;i++){
6            for(int j=1;j<m;j++){
7                grid[i][j]+=grid[i][j-1];
8            }
9        }
10        for(int i=1;i<n;i++){
11            for(int j=0;j<m;j++){
12                grid[i][j]+=grid[i-1][j];
13            }
14        }
15
16        int count=0;
17        for(int i=0;i<n;i++){
18            for(int j=0;j<m;j++){
19                if(grid[i][j]<=k){
20                    count++;
21                }
22            }
23        }
24        return count;
25    }
26}