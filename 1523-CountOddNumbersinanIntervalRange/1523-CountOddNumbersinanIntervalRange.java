// Last updated: 12/7/2025, 4:24:07 PM
1class Solution {
2    public int countOdds(int low, int high) {
3        int total = high - low + 1;
4        if(total == 1){
5            return low % 2 == 0 ? 0 : 1;
6        }
7        if(low % 2 != 0 && total % 2 != 0){
8            return total/2 +  1;
9        }else{
10            return total/2;
11        }
12    }
13}