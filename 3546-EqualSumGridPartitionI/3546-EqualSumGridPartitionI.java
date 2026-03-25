// Last updated: 3/25/2026, 1:35:12 PM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        long totalrowsum = 0;
4        long[] rowsums = new long[grid.length];
5        for(int i = 0; i < grid.length; i++){
6            long sum = 0;
7            for(int j = 0; j < grid[0].length; j++){
8                sum += grid[i][j];
9            }
10            rowsums[i] = sum;
11            totalrowsum += sum;
12        }
13        long currsum = 0;
14        for(int i =0; i < grid.length; i++){
15            currsum += rowsums[i];
16            if(currsum == totalrowsum - currsum) return true;
17        }
18        long totalcolsum =0;
19        long[] colsums = new long[grid[0].length];
20        for(int j = 0; j < grid[0].length; j++){
21            long sum = 0;
22            for(int i = 0; i < grid.length; i++){
23                sum += grid[i][j];
24            }
25            colsums[j] = sum;
26            totalcolsum += sum;
27        }
28        currsum = 0;
29        for(int i = 0; i < grid[0].length; i++){
30            currsum += colsums[i];
31            if(currsum == totalcolsum - currsum) return true;
32        }
33        return false;
34    }
35}