class Solution {
    public int[] sortedSquares(int[] nums) {
        // for(int i = 0; i < nums.length; i++){
        //     nums[i] = nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;
        int n = nums.length;
        int[] res = new int[n];
        int low = 0, high = n-1, i = n-1;
        while(low <= high){
            int sqlow = nums[low]*nums[low];
            int sqhigh = nums[high]*nums[high];
            if(sqlow > sqhigh){
                res[i] = sqlow;
                low++;
            }else{
                res[i] = sqhigh;
                high--;
            }
            i--;
        }
        return res;
    }
}
