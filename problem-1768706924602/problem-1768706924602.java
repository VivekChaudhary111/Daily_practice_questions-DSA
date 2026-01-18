// Last updated: 1/18/2026, 8:58:44 AM
1class Solution {
2    public int maxCapacity(int[] costs, int[] capacity, int budget) {
3        int[][] paired = new int[costs.length][2];
4        for(int i = 0; i < costs.length; i++){
5            paired[i][0] = costs[i];
6            paired[i][1] = capacity[i];
7        }
8        Arrays.sort(paired, (a,b)-> a[0]-b[0]);
9        int[] premax = new int[costs.length];
10        premax[0] = paired[0][1];
11        for(int i = 1; i < costs.length; i++){
12            
13            premax[i] = Math.max(paired[i][1], premax[i-1]);
14        }
15        int maxcap = 0;
16        for(int i = 0; i < costs.length; i++){
17            if(paired[i][0] < budget){
18                maxcap = Math.max(maxcap, paired[i][1]);
19                int rem = budget - paired[i][0] - 1;
20                if(rem >= 0){
21                    int j = BS(paired, rem, i) - 1;
22                    if(j >=0){
23                        maxcap = Math.max(maxcap, paired[i][1] + premax[j]);
24                    }
25                }
26            }
27        }
28        return maxcap;
29    }
30    private int BS(int[][] a, int rem, int r){
31        int l = 0;
32        while(l < r){
33            int mid = l + (r-l)/2;
34            if(a[mid][0] <= rem) l = mid + 1;
35            else r = mid;
36        }
37        return l;
38    }
39}