// Last updated: 2/15/2026, 8:45:02 AM
1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3        if(nums.length == 1) return nums[0];
4        HashMap<Integer, Integer> freq1 = new HashMap<>();
5        for(int num: nums){
6            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
7        }
8        HashMap<Integer, Integer> freq2 = new HashMap<>();
9        for(int val: freq1.values()){
10            freq2.put(val, freq2.getOrDefault(val, 0) + 1);
11        }
12        for(int num : nums){
13            if(freq2.get(freq1.get(num)) == 1)
14                return num;
15        }
16        return -1;
17    }
18}