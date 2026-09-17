// Last updated: 9/17/2026, 11:39:33 PM
1class Solution {
2    public int subsetXORSum(int[] nums) {
3        List<List<Integer>> ans = new ArrayList<>();
4        getSubsets(nums, 0, ans, new ArrayList<>());
5        int total = 0;
6        for(List<Integer> subset : ans){
7            int xor = 0;
8            for(int num : subset){
9                xor ^= num;
10            }
11            total += xor;
12        }
13        return total;
14    }
15    public void getSubsets(int[] nums, int i, List<List<Integer>> ans, List<Integer> subset){
16        if(i == nums.length){
17            ans.add(new ArrayList(subset));
18            return;
19        }
20
21        subset.add(nums[i]);
22        getSubsets(nums, i + 1, ans, subset);
23
24        subset.remove(subset.size() - 1);
25        getSubsets(nums, i + 1, ans, subset);
26
27    }
28}