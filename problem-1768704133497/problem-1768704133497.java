// Last updated: 1/18/2026, 8:12:13 AM
1class Solution {
2    public int vowelConsonantScore(String s) {
3        Set<Character> set = Set.of('a', 'e', 'i','o', 'u');
4        int v = 0, c = 0;
5        for(char ch : s.toCharArray()){
6            if(ch >= 'a' && ch <= 'z'){
7                if(set.contains(ch)) v++;
8                else c++;
9            }
10        }
11        if(c!= 0){
12            return v/c;
13        }
14        return 0;
15    }
16}