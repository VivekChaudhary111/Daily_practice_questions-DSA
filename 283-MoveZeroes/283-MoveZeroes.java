// Last updated: 9/26/2025, 5:23:01 PM
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }
        for(int i = k; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}