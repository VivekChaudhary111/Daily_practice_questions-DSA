// Last updated: 12/8/2025, 2:12:13 PM
1class Solution {
2    public int countTriples(int n) {
3        int cnt = 0;
4        for(int i = 1; i <= n-1; i++){
5            for(int j = i+1; j <= n; j++){
6                double c = Math.sqrt(i*i + j*j);
7                if(c <= n && c == (int) c){
8                    cnt++;
9                }
10            }
11        }
12        return 2*cnt;
13    }
14}