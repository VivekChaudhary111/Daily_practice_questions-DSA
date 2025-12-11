// Last updated: 12/11/2025, 10:27:42 AM
1class Solution {
2    public int specialTriplets(int[] nums) {
3        HashMap<Integer, Integer> mapR = new HashMap<>();
4        for(int i = 0 ; i < nums.length; i++){
5            mapR.put(nums[i], mapR.getOrDefault(nums[i], 0) + 1);
6        }
7        HashMap<Integer, Integer> mapL = new HashMap<>();
8        long ans = 0;
9        for(int num : nums){
10            mapR.put(num, mapR.getOrDefault(num, 0) - 1);
11            int right = mapR.getOrDefault(num*2, 0);
12            int left = mapL.getOrDefault(num*2, 0);
13            ans = (ans + (long) right*left)%1000000007;
14            mapL.put(num, mapL.getOrDefault(num, 0) + 1);
15        }
16        return (int) ans;
17    }
18}