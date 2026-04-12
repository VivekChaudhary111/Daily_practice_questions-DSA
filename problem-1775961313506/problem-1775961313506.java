// Last updated: 4/12/2026, 8:05:13 AM
1class Solution {
2    public int[] findDegrees(int[][] matrix) {
3        int n = matrix.length;
4        int[] ans = new int[n];
5        for(int i =0; i < n; i++){
6            for(int j = i; j < n; j++){
7                if(matrix[i][j] == 1){
8                    ans[i]++;
9                    ans[j]++;
10                }
11            }
12        }
13        return ans;
14    }
15}