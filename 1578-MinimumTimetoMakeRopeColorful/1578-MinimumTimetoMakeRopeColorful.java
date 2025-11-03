// Last updated: 11/3/2025, 4:59:57 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int l_idx = 0;
        int ans = 0;
        for(int i = 1; i < colors.length(); i++){
            if(colors.charAt(i) == colors.charAt(l_idx)){
                if(neededTime[i] <= neededTime[l_idx]){
                    ans += neededTime[i];
                }else{
                    ans += neededTime[l_idx];
                    l_idx = i;
                }
            }else{
                l_idx = i;
            }
        }
        return ans;
    }
}