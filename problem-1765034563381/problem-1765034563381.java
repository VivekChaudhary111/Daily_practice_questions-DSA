// Last updated: 12/6/2025, 8:52:43 PM
1class Solution {
2    public static List<Integer> binaryPal = new ArrayList<>();
3    static {
4        binaryPal.add(0);
5        binaryPal.add(1);
6        for (int len = 2; len <= 30; len++) {
7            int halfLen = (len + 1) / 2;
8            int st = 1 << (halfLen - 1);
9            int end = (1 << halfLen) - 1;
10            for (int i = st; i <= end; i++) {
11                long res = i; 
12                int temp = i;
13                if (len % 2 != 0) {
14                    temp >>= 1; 
15                }
16                while (temp > 0) {
17                    res = (res << 1) | (temp & 1);
18                    temp >>= 1;
19                }
20                binaryPal.add((int) res);
21            }
22        }
23        Collections.sort(binaryPal);
24    }
25
26    public int[] minOperations(int[] nums) {
27        int n = nums.length;
28        int[] ans = new int[n];
29        for (int i = 0; i < n; i++) {
30            ans[i] = find(nums[i]);
31        }
32        return ans;
33    }
34    public int find(int target) {
35        int idx = Collections.binarySearch(binaryPal, target);
36
37        if (idx >= 0) return 0;
38
39        int point = -idx - 1;
40        int minDiff = Integer.MAX_VALUE;
41        if (point < binaryPal.size()) {
42            minDiff = Math.min(minDiff, binaryPal.get(point) - target);
43        }
44        if (point > 0) {
45            minDiff = Math.min(minDiff, target - binaryPal.get(point - 1));
46        }
47        return minDiff;
48    }
49}