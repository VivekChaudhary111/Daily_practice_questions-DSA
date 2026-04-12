// Last updated: 4/13/2026, 1:01:40 AM
1class Solution {
2    int dist(int a, int b){
3        if(a==26 || b==26) return 0;
4        return Math.abs(a/6-b/6) + Math.abs(a%6-b%6);
5    }
6
7    public int minimumDistance(String word) {
8        int n = word.length();
9        int INF = (int)1e9;
10
11        int[] dp = new int[27];
12        Arrays.fill(dp, INF);
13        dp[26] = 0;
14
15        for(int i=1;i<n;i++){
16            int[] next = new int[27];
17            Arrays.fill(next, INF);
18
19            int prev = word.charAt(i-1)-'A';
20            int cur  = word.charAt(i)-'A';
21
22            for(int j=0;j<=26;j++){
23                if(dp[j]==INF) continue;
24
25                next[j] = Math.min(
26                    next[j],
27                    dp[j] + dist(prev,cur)
28                );
29
30                next[prev] = Math.min(
31                    next[prev],
32                    dp[j] + dist(j,cur)
33                );
34            }
35
36            dp = next;
37        }
38
39        int ans = INF;
40        for(int x: dp)
41            ans = Math.min(ans, x);
42
43        return ans;
44    }
45}