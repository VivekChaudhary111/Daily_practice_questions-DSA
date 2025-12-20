// Last updated: 12/20/2025, 8:30:14 PM
1class Solution {
2    public int minOperations(int[] nums) {
3        int count = 0;
4        Set<Integer> set = new HashSet<>();
5        for(int i = nums.length-1; i>= 0; i--){
6            if(!set.contains(nums[i])){
7                set.add(nums[i]);
8                count++;
9            }
10            else{
11                break;
12            }
13        }
14        int ans = (int) Math.ceil((nums.length - count)/3.0);
15        return ans;
16        
17    }
18}