// Last updated: 4/5/2026, 8:11:36 AM
1class Solution {
2    public int mirrorFrequency(String s) {
3        int[] chf = new int[26];
4        int[] dgf = new int[10];
5        for(char ch : s.toCharArray()){
6            if(Character.isDigit(ch)){
7                dgf[ch - '0']++;
8            }else{
9                chf[ch - 'a']++;
10            }
11        }
12        int ans = 0;
13        int i = 0, j = 25;
14        while(i < j){
15            ans += Math.abs(chf[i] - chf[j]);
16            i++;
17            j--;
18        }
19        i = 0;
20        j = 9;
21        while(i < j){
22            ans += Math.abs(dgf[i] - dgf[j]);
23            i++;
24            j--;
25        }
26        return ans;
27    }
28}