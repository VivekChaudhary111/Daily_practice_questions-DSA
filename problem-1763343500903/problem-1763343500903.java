// Last updated: 11/17/2025, 7:08:20 AM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastidx  = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(lastidx != -1 && i - lastidx - 1 < k){
                    return false;
                }
                lastidx = i;
            }
        }
        return true;
    }
}