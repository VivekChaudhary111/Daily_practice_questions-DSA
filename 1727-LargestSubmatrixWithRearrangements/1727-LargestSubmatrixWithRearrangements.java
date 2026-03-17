// Last updated: 3/17/2026, 11:39:21 AM
1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        for(int i = 1; i < m; i++){
6            for(int j = 0; j < n; j++){
7                if(matrix[i][j] == 1 && matrix[i-1][j] != 0){
8                    matrix[i][j] += matrix[i-1][j];
9                }
10            }
11        }
12        for(int i = 0; i < m; i++){
13            Arrays.sort(matrix[i]);
14        }
15        int ans = 0;
16        for(int i = 0; i < m; i++){
17            for(int j = 0; j < n; j++){
18                if(matrix[i][j] != 0){
19                    ans = Math.max(ans, matrix[i][j]* (n-j));
20                }
21            }
22        }
23        return ans;
24    }
25}