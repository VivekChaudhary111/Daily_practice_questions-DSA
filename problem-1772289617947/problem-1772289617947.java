// Last updated: 2/28/2026, 8:10:17 PM
1class Solution {
2    public int[] minDistinctFreqPair(int[] nums) {
3        int[] freq = new int[100 + 1];
4        for(int num: nums){
5            freq[num]++;
6        }
7        for(int i = 1; i < 100; i++){
8            for(int j = i + 1; j < 101; j++){
9                if(freq[i] != 0 && freq[j] != 0){
10                    if(freq[i] != freq[j]){
11                        return new int[] {i, j};
12                    }
13                }
14            }
15        }
16        return new int[] {-1, -1};
17    }
18}