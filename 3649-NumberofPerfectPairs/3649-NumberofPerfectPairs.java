// Last updated: 1/30/2026, 11:53:56 PM
1class Solution {
2    public long perfectPairs(int[] nums) {
3        var sorted = new ArrayList<Integer>();
4        for (int num : nums) {
5            sorted.add(Math.abs(num));
6        }
7        Collections.sort(sorted);
8        
9        int n = sorted.size();
10        long ans = 0;
11        for (int i = 0; i < n; i++) {
12            int index = binSearch(sorted, i + 1, n, sorted.get(i) * 2);
13            ans += index - i - 1;
14        }
15        return ans;
16    }
17    
18    private int binSearch(List<Integer> sorted, int left, int right, int target) {
19        if (left >= right) return right;
20        int mid = left + (right - left) / 2;
21        if (sorted.get(mid) <= target) {
22            return binSearch(sorted, mid + 1, right, target);
23        } else {
24            return binSearch(sorted, left, mid, target);
25        }
26    }
27}