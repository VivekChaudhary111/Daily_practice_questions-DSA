// Last updated: 11/30/2025, 8:18:05 AM
1class Solution {
2    public int maxDistinct(String s) {
3        Set<Character> set = new HashSet<>();
4        int cnt = 0;
5        for(char ch : s.toCharArray()){
6            if(!set.contains(ch)){
7                cnt++;
8                set.add(ch);
9            }
10        }
11        return cnt;
12    }
13}