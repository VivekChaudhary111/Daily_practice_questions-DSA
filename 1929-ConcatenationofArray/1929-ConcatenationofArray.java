// Last updated: 11/14/2025, 12:06:18 PM
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*(nums.length)];
        int j = 0;
        for(int i = 0; i < 2*(nums.length); i++){
            ans[i] = nums[j++];
            if(j == nums.length){
                j = 0;
            }
        }
        return ans;
    }
}