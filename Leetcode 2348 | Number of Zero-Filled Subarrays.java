class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long zeros_len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeros_len++;
            }else{
                if(zeros_len != 0){
                    ans += zeros_len*(zeros_len+1)/2;
                    zeros_len = 0;
                }
            }
        }
        if(zeros_len != 0){
            ans += zeros_len*(zeros_len+1)/2;
        }
        return ans;
    }
}
