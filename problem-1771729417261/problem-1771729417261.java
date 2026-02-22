// Last updated: 2/22/2026, 8:33:37 AM
1class Solution {
2    public boolean isDigitorialPermutation(int n) {
3        int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};
4        int copy = n;
5        int sum  = 0, digits = 0;
6        int[] freq = new int[10];
7        while(n > 0){
8            int dig = n%10;
9            freq[dig]++;
10            sum += fact[dig];
11            n /= 10;
12            digits++;
13        }
14        int[] freq2 = new int[10];
15        int sumDigits = 0;
16        while(sum > 0){
17            int dig = sum%10;
18            freq2[dig]++;
19            sum /= 10;
20            sumDigits++;
21        }
22        if(digits != sumDigits) return false;
23        for(int i = 0; i < 10; i++){
24            if(freq[i] != freq2[i]) return false;
25        }
26        return true;
27    }
28}