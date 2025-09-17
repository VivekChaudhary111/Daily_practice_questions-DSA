// Last updated: 9/17/2025, 12:07:47 PM
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
    public static int LIS(int[] arr) {
		// TODO Auto-generated method stub
		int [] dp = new int [arr.length];
		int len = 1;
		dp[0] = arr[0];
		for(int i = 1; i <dp.length; i++) {
			if(arr[i] > dp[len - 1]) {
				dp[len] = arr[i];
				len++;
			}
			else {
				int idx = BinarySearch(dp, 0, len -1, arr[i]);
				dp[idx] = arr[i];
			}
		}
		return len;
 	}

	public static int BinarySearch(int[] dp, int i, int j, int k) {
		// TODO Auto-generated method stub
		int idx = 0;
		while(i <= j) {
			int mid = (i + j)/2;
			if(dp[mid] >= k) {
				idx = mid;
				j = mid - 1;
			}else {
				i = mid + 1;
			}
		}
		return idx;
	}
}