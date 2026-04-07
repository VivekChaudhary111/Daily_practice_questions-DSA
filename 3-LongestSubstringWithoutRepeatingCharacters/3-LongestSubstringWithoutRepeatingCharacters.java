// Last updated: 4/7/2026, 12:40:31 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        Map<Character, Integer> freq = new HashMap<>();
4        int maxLen = 0;
5        int left = 0, right = 0;
6        while(right < s.length()){
7            char ch = s.charAt(right);
8            //shrink
9            if(freq.getOrDefault(ch, 0) != 0) {
10                while(left < right && s.charAt(left) != ch){
11                    freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
12                    left++;
13                }
14                freq.put(ch, freq.get(ch) - 1);
15                left++;
16            }
17            // expand
18            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
19            right++;
20            // calculate
21            maxLen = Math.max(maxLen, right - left);
22        }
23        return maxLen;
24    }
25}