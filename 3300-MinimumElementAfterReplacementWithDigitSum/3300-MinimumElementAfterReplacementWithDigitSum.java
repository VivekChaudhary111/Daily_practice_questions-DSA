// Last updated: 5/29/2026, 11:43:27 PM
1class Solution {
2    public int minElement(int[] nums) {
3        int n = nums.length;
4        for(int i = 0; i<n; i++){
5            int num = nums[i];
6            int new_num = 0;
7            while(num>0){
8                int rem = num%10;
9                new_num += rem;
10                num/=10;
11            }
12            nums[i] = new_num;
13        }
14        int min_num = nums[0];
15        for(int i = 1; i<n; i++){
16            if(nums[i]<min_num){
17                min_num = nums[i];
18            }
19        }
20        return min_num;
21        
22    }
23}