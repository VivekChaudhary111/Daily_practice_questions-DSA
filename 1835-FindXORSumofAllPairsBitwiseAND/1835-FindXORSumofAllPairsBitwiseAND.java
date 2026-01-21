// Last updated: 1/21/2026, 12:10:56 PM
1class Solution {
2    public int getXORSum(int[] arr1, int[] arr2) {
3        int xor1 = 0;
4        int xor2 = 0;
5        for(int num: arr1){
6            xor1 ^= num;
7        }
8        for(int num : arr2){
9            xor2 ^= num;
10        }
11        return xor1 & xor2;
12    }
13}