// Last updated: 12/20/2025, 1:52:27 AM
1class Solution {
2    public int findLHS(int[] nums) {
3        int n = nums.length;
4        if(n==1) return 0;
5        Arrays.sort(nums);
6        int min = 0;
7        int max_len = 0;
8        int curr_len = 1;
9        for(int i = 1; i < n; i++){
10            if(nums[i] - nums[min] == 0){
11                curr_len++;
12            }
13            else if(nums[i] - nums[min] == 1){
14                curr_len++;
15                if(curr_len > max_len){
16                    max_len = curr_len;
17                }
18            }
19            else if(nums[i] - nums[min] > 1){
20                while(nums[i] - nums[min] > 1){
21                    min++;
22                    curr_len--;
23                }
24                curr_len++;
25            }
26        }
27        return max_len;
28    }
29}