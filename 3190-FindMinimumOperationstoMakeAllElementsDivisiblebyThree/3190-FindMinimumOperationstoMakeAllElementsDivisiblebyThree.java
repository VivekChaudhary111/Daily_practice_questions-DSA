// Last updated: 11/22/2025, 2:21:13 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
           if(nums[i] %3 ==0){
            continue;
           } else{
            sum++;
           }
        }
        
        return sum;
    }
}