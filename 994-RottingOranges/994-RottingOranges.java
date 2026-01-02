// Last updated: 1/3/2026, 1:52:40 AM
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
15        if(cnt == 0) return 0;
16
17        int ans = 0;
18        while(!q.isEmpty()){
19            int[] a = q.poll();
20            int row = a[0], col = a[1], minutes = a[2];
21
22            if(grid[row][col] == 1) {
23                grid[row][col] = 2;
24                cnt--;
25                if(minutes > ans) ans=minutes;
26            }
27            
28
29            int[][] dr = {{0,1},{1,0},{0,-1},{-1,0}};
30            for(int[] d : dr){
31                int nr = row + d[0], nc = col + d[1];
32                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length){
33                    if(grid[nr][nc] == 1){
34                        q.add(new int[] {nr, nc, minutes+1});
35                    }
36                }
37            }
38        }
39        return cnt==0 ? ans : -1;
40
41    }
42}