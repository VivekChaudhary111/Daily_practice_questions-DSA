// Last updated: 2/27/2026, 2:19:01 AM
1public class Solution {
2
3    public int numSteps(String s) {
4        int N = s.length();
5
6        int operations = 0;
7        int carry = 0;
8        for (int i = N - 1; i > 0; i--) {
9            int digit = (s.charAt(i)-'0') + carry;
10
11            if (digit % 2 == 1) {
12                operations += 2;
13                carry = 1;
14            } else {
15                operations++;
16            }
17        }
18
19        return operations + carry;
20    }
21}