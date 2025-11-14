// Last updated: 11/14/2025, 12:19:41 PM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i = 0;
        for(int j = 0; j < n; j++){
            ans[j*2] = nums[i];
            ans[j*2+1] = nums[i+n];
            i++;
        }
        return ans;
    }
}