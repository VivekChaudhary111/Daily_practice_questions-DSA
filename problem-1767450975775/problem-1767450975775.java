// Last updated: 1/3/2026, 8:06:15 PM
1class Solution {
2    public String reversePrefix(String s, int k) {
3        StringBuilder sb = new StringBuilder(s);
4        int i = 0, j = k-1;
5        while(i < j){
6            char ch = sb.charAt(i);
7            sb.setCharAt(i, sb.charAt(j));
8            sb.setCharAt(j, ch);
9            i++;
10            j--;
11        }
12        return sb.toString();
13    }
14}