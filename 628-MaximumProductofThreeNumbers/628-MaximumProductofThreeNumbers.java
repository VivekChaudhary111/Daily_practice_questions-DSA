// Last updated: 9/27/2025, 1:26:08 PM
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if(n == 3){
            return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        int maxProd = nums[0]*nums[1]*nums[2];
        maxProd = Math.max(maxProd, nums[0]*nums[1]*nums[n-1]);
        maxProd = Math.max(maxProd, nums[n-3]*nums[n-2]*nums[n-1]);
        return maxProd;
    }
}