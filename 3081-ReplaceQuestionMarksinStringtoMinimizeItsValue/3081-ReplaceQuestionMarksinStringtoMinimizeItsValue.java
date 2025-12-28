// Last updated: 12/28/2025, 11:59:01 PM
1class Solution {
2    public String minimizeStringValue(String s) {
3        int[] freq = new int[26];
4        List<Character> fill = new ArrayList<>();
5
6        for (char c : s.toCharArray()) {
7            if (c != '?') freq[c - 'a']++;
8        }
9
10        int qCount = 0;
11        for (char c : s.toCharArray()) {
12            if (c == '?') qCount++;
13        }
14
15        for (int i = 0; i < qCount; i++) {
16            int min = 0;
17            for (int j = 1; j < 26; j++) {
18                if (freq[j] < freq[min]) min = j;
19            }
20            fill.add((char) ('a' + min));
21            freq[min]++;
22        }
23
24        Collections.sort(fill);
25
26        StringBuilder sb = new StringBuilder();
27        int idx = 0;
28        for (char c : s.toCharArray()) {
29            if (c == '?') sb.append(fill.get(idx++));
30            else sb.append(c);
31        }
32
33        return sb.toString();
34    }
35}
36