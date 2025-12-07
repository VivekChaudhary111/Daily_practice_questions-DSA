// Last updated: 12/7/2025, 8:53:38 AM
1class Solution {
2    public int[] sortByReflection(int[] nums) {
3        Integer[] boxedNums = new Integer[nums.length];
4        for (int i = 0; i < nums.length; i++) {
5            boxedNums[i] = nums[i];
6        }
7
8        Arrays.sort(boxedNums, (a,b) -> getReflection(a) == getReflection(b) ? a - b : getReflection(a) - getReflection(b));
9
10        for (int i = 0; i < nums.length; i++) {
11            nums[i] = boxedNums[i];
12        }
13        return nums;
14    }
15
16    private int getReflection(int n) {
17        int res = 0;
18        while (n > 0) {
19            res = (res << 1) | (n & 1);
20            n >>= 1;
21        }
22        return res;
23    }
24}