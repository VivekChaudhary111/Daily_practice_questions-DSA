// Last updated: 1/11/2026, 10:43:50 AM
1class Solution {
2    public int minLength(int[] nums, int k) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int sum = 0;
5        int l = 0;
6        int length = Integer.MAX_VALUE;
7        for(int r = 0; r < nums.length; r++){
8            if(map.getOrDefault(nums[r], 0) == 0){
9                sum += nums[r];
10            }
11            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
12
13            while(sum >= k && l <= r){
14                length = Math.min(length, r-l+1);
15                map.put(nums[l], map.get(nums[l]) - 1);
16                if(map.get(nums[l]) == 0){
17                    sum -= nums[l];
18                }
19                l++;
20            }
21        }
22        return length == Integer.MAX_VALUE ? -1 : length;
23    }
24}