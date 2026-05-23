// Last updated: 5/23/2026, 11:51:32 AM
1class Solution {
2    public boolean check(int[] nums) {
3        int cnt = 0;
4        for(int i = 0; i < nums.length-1; i++){
5            if(nums[i] > nums[i+1]) {
6                cnt++;
7                if(cnt > 1) return false;
8            }
9        }
10        if((cnt == 0) || (cnt == 1 && nums[nums.length-1]<=nums[0])) return true;
11        return false;
12    }
13}