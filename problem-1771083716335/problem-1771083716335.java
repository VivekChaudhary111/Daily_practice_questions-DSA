// Last updated: 2/14/2026, 9:11:56 PM
1class Solution {
2    public long rob(int[] nums, int[] colors) {
3        long[] dp = new long[nums.length];
4        if(nums.length == 1) return nums[0];
5        dp[0] = nums[0];
6        if(colors[1] == colors[0]){
7            dp[1] = Math.max(nums[0], nums[1]);
8        }else{
9            dp[1] = nums[0] + nums[1];
10        }
11        for(int i = 2; i < nums.length; i++){
12            long np = dp[i-1];
13            long p;
14            if(colors[i] == colors[i-1]){
15                p = dp[i-2] + nums[i];
16            }else{
17                p = dp[i-1] + nums[i];
18            }
19            dp[i] = Math.max(np, p);
20        }
21        return dp[nums.length - 1];
22        
23    }
24}