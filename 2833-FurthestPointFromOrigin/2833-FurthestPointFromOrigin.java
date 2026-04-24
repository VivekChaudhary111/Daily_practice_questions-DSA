// Last updated: 4/24/2026, 11:34:43 AM
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int len = moves.length();
4        int l = 0, r = 0;
5        for(char ch : moves.toCharArray()){
6            if(ch == 'R') r++;
7            else if(ch == 'L') l++;
8        }
9        return Math.abs(l-r) + len - (l+r);
10    }
11}