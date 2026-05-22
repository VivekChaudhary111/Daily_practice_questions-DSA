// Last updated: 5/22/2026, 5:46:40 PM
1class Solution {
2    public int search(int[] nums, int target) {
3        int i = 0, j = nums.length - 1;
4        while(i <= j){
5            int mid  = i + (j-i)/2;
6            if(nums[mid] == target){
7                return mid;
8            }else if(target < nums[mid]){
9                if(nums[i] <= nums[mid] &&  target < nums[i]){
10                    i = mid + 1;
11                }else{
12                    j = mid - 1;
13                }
14            }else{
15                if(target > nums[j] && nums[j] >= nums[mid]){
16                    j = mid - 1;
17                }else{
18                    i = mid + 1;
19                }
20            }
21        }
22        return -1;
23    }
24}