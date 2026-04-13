// Last updated: 4/13/2026, 10:27:47 AM
1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3        int ans = 1001;
4        for(int i = 0; i < nums.length; i++){
5            if(nums[i] == target) ans = Math.min(ans, Math.abs(i - start));
6        }
7        return ans;
8    }
9}