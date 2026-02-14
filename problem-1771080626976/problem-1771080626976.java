// Last updated: 2/14/2026, 8:20:26 PM
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder ans = new StringBuilder();
4        for(String s : words){
5            int currw = 0;
6            for(char ch : s.toCharArray()){
7                currw += weights[(int) (ch-'a')];
8            }
9            currw %= 26;
10            ans.append((char) ('z' - currw));
11            
12        }
13        return ans.toString();
14        
15    }
16}