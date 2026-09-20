// Last updated: 9/20/2026, 9:57:19 PM
1class Solution {
2    public int reverseDegree(String s) {
3        int res = 0;
4        for(int i = 0; i < s.length(); i++){
5            int reverse = 'z' - s.charAt(i) + 1;
6            res += reverse * (i + 1);
7        }
8        return res;
9    }
10}