// Last updated: 4/20/2026, 7:58:49 AM
1class Solution {
2    public int maxDistance(int[] colors) {
3        int ans = 0;
4        for(int i = 0; i < colors.length; i++){
5            for(int j = colors.length -1; j >= 0; j--){
6                if(colors[i] != colors[j]){
7                    ans = Math.max(ans, j - i);
8                    break;
9                }
10            }
11        }
12        return ans;
13    }
14}