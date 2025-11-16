// Last updated: 11/16/2025, 3:50:51 PM
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = upperBound(arr, nums[i]);
        }
        return ans;

    }
    public static int upperBound(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}