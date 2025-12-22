// Last updated: 12/22/2025, 4:48:46 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5        
6        boolean[] sorted = new boolean[n - 1];
7        int deletions = 0;
8
9        for (int col = 0; col < m; col++) {
10            boolean needDelete = false;
11
12            for (int row = 0; row < n - 1; row++) {
13                if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
14                    needDelete = true;
15                    break;
16                }
17            }
18
19            if (needDelete) {
20                deletions++;
21                continue;
22            }
23
24            for (int row = 0; row < n - 1; row++) {
25                if (!sorted[row] && strs[row].charAt(col) < strs[row + 1].charAt(col)) {
26                    sorted[row] = true;
27                }
28            }
29        }
30
31        return deletions;
32    }
33}