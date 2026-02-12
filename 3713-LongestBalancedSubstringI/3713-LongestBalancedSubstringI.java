// Last updated: 2/12/2026, 6:55:44 AM
1class Solution {
2    public int longestBalanced(String s) {
3        int maxlen = 0;
4        for(int i = 0; i < s.length(); i++){
5            int[] freq = new int[26];
6            for(int j = i; j < s.length(); j++){
7                freq[s.charAt(j) - 'a']++;
8                if(isValid(freq)){
9                    maxlen = Math.max(maxlen,j - i + 1);
10                }
11            }
12        }
13        return maxlen;
14    }
15    public static boolean isValid(int[] freq){
16        int first = -1;
17        for(int f : freq){
18            if(f > 0){
19                if(first == -1){
20                    first = f;
21                }
22                else if(f != first) return false;
23            }
24        }
25        return true;
26    }
27}