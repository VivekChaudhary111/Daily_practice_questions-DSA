// Last updated: 2/7/2026, 8:23:32 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int[][] dp = new int[s.length() + 1][2];
4        for(int[] a : dp){
5            Arrays.fill(a, -1);
6        }
7        return getMinOps(s, 0, 0, dp);
8    }
9    public static int getMinOps(String s, int idx, int isB, int[][] dp){
10        if(idx == s.length()){
11            return 0;
12        }
13        if(dp[idx][isB] != -1) return dp[idx][isB];
14        char ch = s.charAt(idx);
15        int notDelB = Integer.MAX_VALUE;
16        int DelA = notDelB;
17        int notDelA = DelA;
18        int DelB = DelA;
19        if(isB == 1){
20            if(ch =='b'){
21                notDelB = getMinOps(s, idx+1, isB, dp);
22            }else{
23                DelA = 1 + getMinOps(s, idx + 1, isB, dp);
24            }
25        }else{
26            if(ch == 'a'){
27                notDelA = getMinOps(s, idx + 1, isB, dp);
28            }else{
29                notDelB = getMinOps(s, idx + 1, 1, dp);
30                DelB = 1 + getMinOps(s, idx + 1, isB, dp);
31            }
32        }
33        int[] arr = {notDelB, DelB, notDelA, DelA};
34        int min = notDelB;
35        for(int i = 1; i < 4; i++){
36            min = Math.min(arr[i], min);
37        }
38        return dp[idx][isB] = min;
39    }
40}