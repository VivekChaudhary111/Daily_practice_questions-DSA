// Last updated: 3/31/2026, 11:07:12 AM
1class Solution {
2    public String generateString(String S, String t) {
3        char[] s = S.toCharArray();
4        int n = s.length;
5        int m = t.length();
6        char[] ans = new char[n + m - 1];
7        Arrays.fill(ans, '?'); // '?' indicates undecided positions
8
9        // Process T
10        for (int i = 0; i < n; i++) {
11            if (s[i] != 'T') {
12                continue;
13            }
14            // Substring must equal t
15            for (int j = 0; j < m; j++) {
16                char v = ans[i + j];
17                if (v != '?' && v != t.charAt(j)) {
18                    return "";
19                }
20                ans[i + j] = t.charAt(j);
21            }
22        }
23
24        char[] oldAns = ans.clone();
25        for (int i = 0; i < ans.length; i++) {
26            if (ans[i] == '?') {
27                ans[i] = 'a'; // initial value for undecided positions is 'a'
28            }
29        }
30
31        // Process F
32        for (int i = 0; i < n; i++) {
33            if (s[i] != 'F') {
34                continue;
35            }
36            // Substring must not equal t
37            if (!new String(ans, i, m).equals(t)) {
38                continue;
39            }
40            // Find the last undecided position
41            boolean ok = false;
42            for (int j = i + m - 1; j >= i; j--) {
43                if (oldAns[j] == '?') { // previously filled with 'a', now change to 'b'
44                    ans[j] = 'b';
45                    ok = true;
46                    break;
47                }
48            }
49            if (!ok) {
50                return "";
51            }
52        }
53
54        return new String(ans);
55    }
56}