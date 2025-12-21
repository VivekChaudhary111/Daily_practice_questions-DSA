// Last updated: 12/21/2025, 11:25:17 PM
1class Solution {
2    public String longestNiceSubstring(String s) {
3        if (s.length() < 2) return "";
4
5        int mid = -1;
6        Set<Character> set = new HashSet<Character>();
7        for(int i=0; i<s.length(); i++){
8            set.add(s.charAt(i));
9        }
10    
11        for (int i=0; i<s.length(); i++){
12            if(!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
13                mid = i;
14                break;
15            }
16        }
17        if(mid == -1) return s;
18        String left  = longestNiceSubstring(s.substring(0,mid));
19        String right = longestNiceSubstring(s.substring(mid+1));
20
21        return left.length() >= right.length()? left:right;
22    }
23}