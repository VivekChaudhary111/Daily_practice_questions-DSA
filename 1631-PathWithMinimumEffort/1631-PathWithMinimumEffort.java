// Last updated: 1/2/2026, 4:22:29 PM
1class Solution {
2    public int minimumEffortPath(int[][] heights) {
3        int low = 0;
4        int high = 1_000_000;
5        int ans = -1;
6        while(low <= high){
7            int mid = low + (high - low)/2;
8            if(isPossible(heights, mid)){
9                high = mid - 1;
10                ans = mid;
11            }else{
12                low = mid + 1;
13            }
14        }
15        return ans;
16    }
17    public boolean isPossible(int[][] heights, int mid){
18        Queue<int[]> q = new LinkedList<>();
19        boolean[][] vis = new boolean[heights.length][heights[0].length];
20        q.add(new int[] {0,0});
21        while(!q.isEmpty()){
22            int[] a = q.poll();
23            int row = a[0], col = a[1];
24            if(vis[row][col]) continue;
25            vis[row][col] = true;
26            if(row == heights.length-1 && col == heights[0].length-1){
27                return true;
28            }
29            int[] dr = {0, 1, 0, -1};
30            int[] dc = {1, 0, -1, 0};
31            for(int d = 0; d < 4; d++){
32                int nr = row + dr[d], nc = col + dc[d];
33                if(nr < heights.length && nr >= 0 && nc < heights[0].length && nc >= 0){
34                    if(Math.abs(heights[row][col] - heights[nr][nc]) <= mid){
35                        q.add(new int[] {nr, nc});
36                    }
37                }
38            }
39        }
40        return false;
41    }
42}