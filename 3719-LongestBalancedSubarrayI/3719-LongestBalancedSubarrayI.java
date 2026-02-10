// Last updated: 2/11/2026, 5:02:41 AM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        Set<Integer> set1 = new HashSet<>();
4        Set<Integer> set2 = new HashSet<>();
5        int maxlen = 0;
6        for(int i = 0; i < nums.length-1; i++){
7            if(nums[i]%2==0){
8                    set1.add(nums[i]);
9                }else{
10                    set2.add(nums[i]);
11                }
12            for(int j = i + 1; j < nums.length; j++){
13                if(nums[j]%2==0){
14                    set1.add(nums[j]);
15                }else{
16                    set2.add(nums[j]);
17                }
18                if(set1.size() == set2.size()){
19                    maxlen = Math.max(maxlen, j-i+1);
20                }
21            }
22            set1.clear();
23            set2.clear();
24        }
25        return maxlen;
26    }
27}