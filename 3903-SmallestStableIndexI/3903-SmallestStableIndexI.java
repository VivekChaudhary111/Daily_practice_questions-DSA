// Last updated: 9/5/2026, 2:09:19 AM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] preMax = new int[n];
5        preMax[0] = nums[0];
6        for(int i = 1; i < n; i++){
7            preMax[i] = Math.max(preMax[i-1], nums[i]);
8        }
9        int[] suffMin = new int[n];
10        suffMin[n-1] = nums[n-1];
11        for(int i = n - 2; i >= 0; i--){
12            suffMin[i] = Math.min(suffMin[i+1], nums[i]);
13        }
14        for(int i = 0; i< n; i++){
15            if(preMax[i]-suffMin[i] <= k) return i;
16        }
17        return -1;
18    }
19}