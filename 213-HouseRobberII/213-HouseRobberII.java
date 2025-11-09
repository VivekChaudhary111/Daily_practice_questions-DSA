// Last updated: 11/9/2025, 12:23:58 PM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp1 = new int[n];
        dp1[0] = 0;
        for(int i = 1; i < n; i++){
            int curr = nums[i];
            if(i-2 >= 0){
                curr += dp1[i-2];
            }
            dp1[i] = Math.max(dp1[i-1], curr);
        }
        int[] dp2 = new int[n];
        dp2[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            int curr = nums[i];
            if(i+2 < n){
                curr += dp2[i+2];
            }
            dp2[i] = Math.max(dp2[i+1], curr);
        }
        return Math.max(dp1[n-1], dp2[0]);
    }
}