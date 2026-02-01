// Last updated: 2/1/2026, 10:34:21 AM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int cost = nums[0];
4        int mina = nums[1];
5        int minb = nums[2];
6        if(mina > minb){
7            mina = nums[2];
8            minb = nums[1];
9        }
10        for(int i = 3; i < nums.length; i++){
11            if(minb > nums[i]){
12                if(mina > nums[i]){
13                    minb = mina;
14                    mina = nums[i];
15                }else{
16                    minb = nums[i];
17                }
18            } 
19        }
20        return cost + mina + minb;
21    }
22}