// Last updated: 3/3/2026, 1:06:53 AM
1// class Solution {
2//     public int minSwaps(int[][] grid) {
3//         int n = grid.length;
4//         int[] freqZ = new int[n+1];
5//         for(int[] row : grid){
6//             int count = 0;
7//             for(int i = n - 1; i >= 0; i--){
8//                 if(row[i] == 0) count++;
9//                 else break;
10//             }
11//             freqZ[count]++;
12//         }
13//         int curr = n - 1;
14//         for(int i = n; i >= 1; i--){
15//             if(curr <= i) curr -= freqZ[i];
16//             else break;
17//         }
18//         if(curr > 0) return -1;
19        
20//     }
21// }
22class Solution {
23
24    public int minSwaps(int[][] grid) {
25        int n = grid.length;
26        int[] pos = new int[n];
27        Arrays.fill(pos, -1);
28        for (int i = 0; i < n; ++i) {
29            for (int j = n - 1; j >= 0; --j) {
30                if (grid[i][j] == 1) {
31                    pos[i] = j;
32                    break;
33                }
34            }
35        }
36        int ans = 0;
37        for (int i = 0; i < n; ++i) {
38            int k = -1;
39            for (int j = i; j < n; ++j) {
40                if (pos[j] <= i) {
41                    ans += j - i;
42                    k = j;
43                    break;
44                }
45            }
46            if (k >= 0) {
47                for (int j = k; j > i; --j) {
48                    int temp = pos[j];
49                    pos[j] = pos[j - 1];
50                    pos[j - 1] = temp;
51                }
52            } else {
53                return -1;
54            }
55        }
56        return ans;
57    }
58}