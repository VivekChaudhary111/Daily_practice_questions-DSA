// Last updated: 10/26/2025, 8:25:05 AM
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long sum1 = 0;
        long sum2 = 0;
        int mid = nums.length/2;
        for(int i = nums.length - 1; i >= mid; i--){
            sum1+=nums[i]*nums[i];
        }
        for(int i = mid-1; i >= 0; i--){
            sum2 += nums[i]*nums[i];
        }
        return sum1 - sum2;
    }
}