// Last updated: 2/22/2026, 8:14:08 AM
1class Solution {
2    public int scoreDifference(int[] nums) {
3        int p1 = 0;
4        int p2 = 0;
5        boolean isActive = true;
6        for(int i = 0; i < nums.length; i++){
7            if(nums[i]%2 == 1){
8                if(isActive) {
9                    isActive = false;
10                }
11                else {
12                    isActive = true;
13                }
14            }
15            if(i%6 == 5){
16                if(isActive) {
17                    isActive = false;
18                }
19                else {
20                    isActive = true;
21                }
22            }
23            if(isActive) {
24                p1 += nums[i];
25            }
26            else {
27                p2 += nums[i];
28            }
29        }
30        return p1 - p2;
31    }
32}