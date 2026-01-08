// Last updated: 1/8/2026, 11:33:59 PM
1class Solution {
2    public int maxRepeating(String sequence, String word) {
3        int count = 0;
4        String curr = word;
5
6        while (sequence.contains(curr)) {
7            count++;
8            curr += word;
9        }
10
11        return count;
12    }
13}
14