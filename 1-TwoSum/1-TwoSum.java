// Last updated: 3/16/2026, 5:30:01 AM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int[] res = new int[2];
4        int n = nums.length;
5        for(int i = 0; i<n; i++){
6            int check_for = target - nums[i];
7            for(int j = i+1; j<n; j++){
8                if (nums[j] == check_for){
9                    res[0] = i;
10                    res[1] = j;
11                    return res;
12                }
13            }
14        }
15        return res;
16    }
17}