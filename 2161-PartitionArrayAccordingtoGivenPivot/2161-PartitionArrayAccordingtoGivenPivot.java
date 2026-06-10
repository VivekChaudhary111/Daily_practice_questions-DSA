// Last updated: 6/10/2026, 11:55:24 PM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
4        for(int num: nums){
5            if(num < min) min = num;
6            if(num > max) max = num;
7        }
8        long ans = (long) k*(max-min);
9        return ans;
10    }
11}