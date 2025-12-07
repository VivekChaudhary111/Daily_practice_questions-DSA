// Last updated: 12/7/2025, 9:04:11 AM
1class Solution {
2    public int[] sortByReflection(int[] nums) {
3        Integer[] Nums = new Integer[nums.length];
4        for (int i = 0; i < nums.length; i++) {
5            Nums[i] = nums[i];
6        }
7        Arrays.sort(Nums, (a,b) -> reflection(a) == reflection(b) ? a - b : reflection(a) - reflection(b));
8        for (int i = 0; i < nums.length; i++) {
9            nums[i] = Nums[i];
10        }
11        return nums;
12    }
13    public int reflection(int n) {
14        int ans = 0;
15        while (n > 0) {
16            ans = (ans << 1) | (n & 1);
17            n >>= 1;
18        }
19        return ans;
20    }
21}