// Last updated: 1/17/2026, 8:15:30 PM
1class Solution {
2    public int[] bestTower(int[][] towers, int[] center, int radius) {
3        int[] ans = {-1,-1};
4        int maxq = -1;
5        for(int[] tower: towers){
6            int dist = Math.abs(center[0] - tower[0]) + Math.abs(center[1] - tower[1]);
7            if(dist <= radius){
8                if(tower[2] > maxq){
9                    ans[0] = tower[0];
10                    ans[1] = tower[1];
11                    maxq = tower[2];
12                }
13                if(tower[2] == maxq){
14                    if(ans[0] > tower[0] || (ans[0] == tower[0] && ans[1] > tower[1])){
15                        ans[0] = tower[0];
16                        ans[1] = tower[1];
17                    }
18                }
19            }
20        }
21        return ans;
22    }
23}