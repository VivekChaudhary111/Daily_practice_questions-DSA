// Last updated: 5/15/2026, 11:53:40 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length;
4        if(n==2){
5            if(nums[0]<=nums[1]){
6                return nums[0];
7            }return nums[1];
8        }
9        int low = 0;
10        int high = n - 1;
11        int ans = nums[0];
12        while(low<=high){
13            int mid = low + (high-low)/2;
14            if(nums[mid] <= ans){
15                ans = nums[mid];
16                high = mid - 1;
17            }else{
18                low = mid + 1;
19            }
20        }
21        return ans;
22    }
23}