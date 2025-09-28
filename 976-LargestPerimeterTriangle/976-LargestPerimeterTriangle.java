// Last updated: 9/28/2025, 5:40:19 PM
class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i<n-2; i++){
            if(nums[i]+nums[i+1] > nums[i+2]){
                ans = Math.max(ans, nums[i]+nums[i+1]+nums[i+2]);
            }
        }
        return ans;
    }
}