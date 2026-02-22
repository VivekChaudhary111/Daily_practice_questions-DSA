// Last updated: 2/22/2026, 8:43:50 AM
1class Solution {
2    public String maximumXor(String s, String t) {
3        int[] f= new int[2];
4        for(char ch: t.toCharArray()){
5            if(ch == '0') f[0]++;
6            else f[1]++;
7        }
8        StringBuilder ans = new StringBuilder();
9        for(char ch: s.toCharArray()){
10            if(ch == '0'){
11                if(f[1] > 0){
12                    ans.append(1);
13                    f[1]--;
14                }else{
15                    ans.append(0);
16                    f[0]--;
17                }
18            }else{
19                if(f[0] > 0){
20                    ans.append(1);
21                    f[0]--;
22                }else{
23                    ans.append(0);
24                    f[1]--;
25                }
26            }
27        }
28        return ans.toString();
29    }
30}