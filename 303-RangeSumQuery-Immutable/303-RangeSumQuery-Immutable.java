// Last updated: 3/24/2026, 11:07:31 AM
1class NumArray {
2    int[] prefix;
3    public NumArray(int[] nums) {
4        prefix = new int[nums.length + 1];
5        prefix[0] = 0;
6        for(int i = 1; i < nums.length + 1; i++){
7            prefix[i] = prefix[i - 1] + nums[i-1];
8        }
9    }
10    
11    public int sumRange(int left, int right) {
12        return prefix[right + 1] - prefix[left];
13    }
14}
15
16/**
17 * Your NumArray object will be instantiated and called as such:
18 * NumArray obj = new NumArray(nums);
19 * int param_1 = obj.sumRange(left,right);
20 */