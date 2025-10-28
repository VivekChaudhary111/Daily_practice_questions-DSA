// Last updated: 10/28/2025, 11:10:06 AM
class Solution {
    public int countValidSelections(int[] nums) {
        int valid = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                int l_sum = 0;
                int r_sum = 0;
                for(int j = 0; j<i; j++){
                    l_sum += nums[j];
                }
                for(int k = nums.length - 1; k>i; k--){
                    r_sum += nums[k];
                }
                if(l_sum == r_sum){
                    valid += 2;
                }if(l_sum-r_sum == 1 || r_sum-l_sum == 1){
                    valid++;
                }
                
            }
        }
        return valid;
    }
}