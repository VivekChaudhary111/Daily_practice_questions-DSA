// Last updated: 10/12/2026, 11:29:08 PM
1class Solution {
2    public boolean threeFibonacciSum(int n) {
3        int first  = 0;
4        int second = 1;
5        int third = 1;
6        while(first + second + third <= n){
7            if(first + second + third == n){
8                return true;
9            }
10            int temp = second + third;
11            first = second;
12            second = third;
13            third = temp;
14        }
15        return false;
16    }
17}