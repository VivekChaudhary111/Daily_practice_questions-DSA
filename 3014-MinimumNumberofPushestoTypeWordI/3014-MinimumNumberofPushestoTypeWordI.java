// Last updated: 7/31/2026, 12:46:16 AM
1class Solution {
2    public int minimumPushes(String word) {
3        int[][] freq = new int[26][2];
4        for(char ch : word.toCharArray()){
5            freq[ch-'a'][0] = (int) ch-'a';
6            freq[ch-'a'][1]++;
7        }
8        Arrays.sort(freq, (a,b)->b[1]-a[1]);
9        int ans = 0;
10        for(int i = 0; i < 3; i++){
11            for(int j = i*8; j < 8*(i+1); j++){
12                ans += freq[j][1]*(i + 1);
13            }
14        }
15        ans += freq[24][1]*4;
16        ans += freq[25][1]*4;
17        return ans;
18    }
19}