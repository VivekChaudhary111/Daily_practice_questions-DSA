// Last updated: 3/27/2026, 6:17:34 PM
1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int n = mat.length;
4        int m = mat[0].length;
5        int[][] modified = new int[n][m];
6        k = k % m;
7        for(int i = 0; i < n; i++){
8            if(i % 2 == 0){
9                modified[i] = rotate(mat[i], k);
10            }else{
11                modified[i] = rotate(mat[i], k);
12            }
13        }
14        for(int i = 0; i < n; i++){
15            for(int j = 0; j < m; j++){
16                if(modified[i][j] != mat[i][j]) return false;
17            }
18        }
19        return true;
20
21    }
22    int[] rotate(int[] row, int k){
23        int n = row.length;
24        int[] newarr = new int[n];
25        for(int i = 0; i < n; i++){
26            newarr[i] = row[(i + k) % n];
27        }
28        return newarr;
29    }
30}