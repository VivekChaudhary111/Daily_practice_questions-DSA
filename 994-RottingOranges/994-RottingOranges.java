// Last updated: 1/3/2026, 1:38:56 AM
1class Solution {
2    public int orangesRotting(int[][] grid) {
3        Queue<int[]> q = new LinkedList();
4        int cnt = 0;
5        for(int i = 0 ; i < grid.length; i++){
6            for(int j = 0; j < grid[0].length; j++){
7                if(grid[i][j] == 2){
8                    q.offer(new int[] {i, j, 0});
9                }
10                else if(grid[i][j] == 1){
11                    cnt++;
12                }
13            }
14        }
15        boolean[][] vis = new boolean[grid.length][grid[0].length];
16        int ans = 0;
17        while(!q.isEmpty()){
18            int[] a = q.poll();
19            int row = a[0], col = a[1], minutes = a[2];
20            if(vis[row][col]) continue;
21            vis[row][col] = true;
22
23            // if(grid[row][col] != 1) continue;
24            if(grid[row][col] == 1) cnt--;
25            if(minutes > ans) ans=minutes;
26            if(cnt == 0) break;
27
28            int[][] dr = {{0,1},{1,0},{0,-1},{-1,0}};
29            for(int[] d : dr){
30                int nr = row + d[0], nc = col + d[1];
31                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length){
32                    if(!vis[nr][nc] && grid[nr][nc] == 1){
33                        q.add(new int[] {nr, nc, minutes+1});
34                    }
35                }
36            }
37        }
38        return cnt==0 ? ans : -1;
39
40    }
41}