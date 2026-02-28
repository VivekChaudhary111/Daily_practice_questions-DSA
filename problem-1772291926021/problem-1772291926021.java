// Last updated: 2/28/2026, 8:48:46 PM
1class Solution {
2    public String mergeCharacters(String s, int k) {
3        String s1 = merge(s, k, 0, 1);
4        return s1;
5    }
6    public String merge(String s, int k, int i, int j){
7        if(i >= s.length()) return s;
8        if(j - i > k || j >= s.length()) return merge(s, k, i + 1, i+2);
9        if(s.charAt(i) == s.charAt(j)){
10            s = s.substring(0, j) + s.substring(j+1);
11            return merge(s, k, 0, 1);
12        }
13        return merge(s, k, i, j+1);
14    }
15}