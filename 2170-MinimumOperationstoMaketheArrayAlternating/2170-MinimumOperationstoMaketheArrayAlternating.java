// Last updated: 1/18/2026, 10:40:45 PM
1class Solution {
2    public int minimumOperations(int[] nums) {
3        int freq[][] = new int[100005][2];
4        int i, j, k, ans=0;
5        for(i = 0; i < nums.length; i++) {
6    			freq[nums[i]][i&1]++;
7    		}
8    		
9    		for(i = 1, j=k=0; i <= 100000; i++) {
10    		ans = Math.max(ans, Math.max(freq[i][0] + k, freq[i][1] + j));
11            j = Math.max(j, freq[i][0]);
12            k = Math.max(k, freq[i][1]);
13        }
14        return nums.length - ans;
15    }
16}