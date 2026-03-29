// Last updated: 3/29/2026, 8:02:39 AM
1class Solution {
2    public int firstMatchingIndex(String s) {
3        int i = 0, j = s.length() - 1;
4        while(i <= j){
5            if(s.charAt(i) == s.charAt(j)) return i;
6            i++;
7            j--;
8        }
9        return -1;
10    }
11}