class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int evens = 0;
        int odds = 0;
        for(int i = 0; i < n; i++){
            if(nums[i]%2==0) {
                evens++;
            }else{
                odds++;
            }
        }
        if(Math.abs(evens-odds)>1) return -1;
        int ans = Integer.MAX_VALUE;
        if(evens>=odds){
            ans = Math.min(ans, countSwap(nums, 0)); 
        }
        if(evens<=odds){
            ans = Math.min(ans, countSwap(nums, 1)); 
        }
        return ans;
    }
    public static int countSwap(int[] nums,int state){
        int swaps = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == state){
                swaps += Math.abs(curr - i);
                curr += 2;
            }
        }
        return swaps;
        
    }
}
