// Last updated: 12/28/2025, 10:58:00 PM
1class Solution {
2    public long maximumSubsequenceCount(String text, String pattern) {
3        int p1 =0, p2 = 0;
4        long subs = 0;
5        for(char ch : text.toCharArray()){
6            if(pattern.charAt(0) != pattern.charAt(1) && ch == pattern.charAt(0)) p1++;
7            else if(pattern.charAt(0) == pattern.charAt(1) && ch == pattern.charAt(0)) {
8                subs +=p1++;
9            }
10            else if(ch == pattern.charAt(1)) {
11                p2++;
12                subs += p1;
13            }
14        }
15        return Math.max(subs + p1, subs + p2);
16    }
17}