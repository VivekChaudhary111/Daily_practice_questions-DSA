// Last updated: 7/26/2026, 12:53:56 AM
1class Solution {
2    public int maxProduct(int n) {
3        int[] arr = new int[10];
4        int idx = 0;
5        while(n > 0){
6            arr[idx++] = n % 10;
7            n /= 10;
8        }
9        Arrays.sort(arr);
10        return arr[9] * arr[8];
11    }
12}