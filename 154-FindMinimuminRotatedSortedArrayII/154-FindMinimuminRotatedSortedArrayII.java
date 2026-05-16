// Last updated: 5/16/2026, 11:55:08 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int l = 0;
4        int r = nums.length - 1;
5
6        while (l < r) {
7            int mid = l + (r - l) / 2;
8
9            if (nums[mid] < nums[r]) {
10                r = mid;
11            }
12            else if (nums[mid] > nums[r]) {
13                l = mid + 1;
14            }
15            // duplicates
16            else {
17                r--;
18            }
19        }
20
21        return nums[l];
22    }
23}