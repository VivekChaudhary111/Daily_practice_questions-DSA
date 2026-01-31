// Last updated: 1/31/2026, 8:08:26 PM
1class Solution {
2    public String reverseByType(String s) {
3        StringBuilder lower = new StringBuilder();
4        StringBuilder special = new StringBuilder();
5        for(char ch : s.toCharArray()){
6            if(Character.isLetter(ch)){
7                lower.append(ch);
8            }else{
9                special.append(ch);
10            }
11        }
12        StringBuilder ans = new StringBuilder();
13        int i = lower.length() - 1;
14        int j = special.length() - 1;
15        for(char ch : s.toCharArray()){
16            if(Character.isLetter(ch)){
17                ans.append(lower.charAt(i--));
18            }else{
19                ans.append(special.charAt(j--));
20            }
21        }
22        return ans.toString();
23        
24    }
25}