// Last updated: 2/10/2026, 2:21:42 PM
1class Solution {
2    public int solve(int x, int y){
3        int count = 1;
4        while (x != y){
5            if (x > y){
6                x = x/2;
7            } else {
8                y = y/2;
9            }
10            count += 1;
11        }
12        return count;
13    }
14
15    public int[] cycleLengthQueries(int n, int[][] queries) {
16        int[] ans = new int[queries.length];
17
18        for (int i = 0; i < queries.length; i++){
19            int val = solve(queries[i][0],queries[i][1]);
20            ans[i] = val;
21        }
22        return ans;
23    }
24}