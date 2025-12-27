// Last updated: 12/27/2025, 9:19:57 PM
1class Solution {
2    public String resultingString(String s) {
3        StringBuilder res = new StringBuilder();
4
5        for (char ch : s.toCharArray()) {
6            if (res.length() > 0 && 
7                ValidPair(res.charAt(res.length() - 1), ch)) {
8                res.deleteCharAt(res.length() - 1);
9            } else {
10                res.append(ch);
11            }
12        }
13
14        return res.toString();
15    }
16    private boolean ValidPair(char c1, char c2) {
17        if (Math.abs(c1 - c2) == 1) {
18            return true;
19        }
20        if ((c1 == 'a' && c2 == 'z') || (c1 == 'z' && c2 == 'a')) {
21            return true;
22        }
23        return false;
24    }
25}