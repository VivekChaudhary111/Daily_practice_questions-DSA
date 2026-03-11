// Last updated: 3/11/2026, 10:29:07 AM
1class Solution {
2    public int bitwiseComplement(int n) {
3        int i = 1;
4        for(; i < 31; i++){
5            if(Math.pow(2, i) - 1 >= n) break;
6        }
7        return (int)Math.pow(2, i) - 1 - n;
8    }
9}