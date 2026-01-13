// Last updated: 1/13/2026, 11:08:37 PM
1class Solution {
2    public int largestPrime(int n) {
3        if(n < 2) return 0;
4        return PrimeSieve(n);
5    }
6    public static int PrimeSieve(int n) {
7		int[] ans = new int[n+1];
8		ans[0] = ans[1] = 1;
9		for(int i = 2; i * i <= ans.length; i++) {
10			if(ans[i] == 0) {
11				for(int j = 2; i * j < ans.length; j++) {
12					ans[i*j] = 1;
13				}
14				
15			}
16		}
17        int maxSum = 0;
18        long curr = 0;
19        for (int i = 2; i <= n; i++) {
20            if (ans[i] == 0) {
21                curr += i;
22                if (curr > n) {
23                    break;
24                }
25                if (ans[(int)curr] == 0) {
26                    maxSum = (int)curr;
27                }
28            }
29        }
30        return maxSum;
31    }
32}