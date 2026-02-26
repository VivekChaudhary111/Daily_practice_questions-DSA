// Last updated: 2/27/2026, 2:19:58 AM
1public class Solution {
2
3    public int numSteps(String s) {
4        int n = s.length();
5        int ops = 0;
6        int carry = 0;
7        for (int i = n - 1; i > 0; i--) {
8            int digit = (s.charAt(i)-'0') + carry;
9            if (digit % 2 == 1) {
10                ops += 2;
11                carry = 1;
12            } else {
13                ops++;
14            }
15        }
16        return ops + carry;
17    }
18}