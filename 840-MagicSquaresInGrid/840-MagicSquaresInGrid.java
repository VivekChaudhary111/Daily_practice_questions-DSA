// Last updated: 12/30/2025, 8:14:34 AM
1class Solution {
2
3    public int numMagicSquaresInside(int[][] grid) {
4        int ans = 0;
5        int m = grid.length;
6        int n = grid[0].length;
7        for (int row = 0; row + 2 < m; row++) {
8            for (int col = 0; col + 2 < n; col++) {
9                if (isMagicSquare(grid, row, col)) {
10                    ans++;
11                }
12            }
13        }
14        return ans;
15    }
16
17    private boolean isMagicSquare(int[][] grid, int row, int col) {
18        String sequence = "2943816729438167";
19        String sequenceReversed = "7618349276183492";
20
21        StringBuilder border = new StringBuilder();
22        int[] borderIndices = new int[] { 0, 1, 2, 5, 8, 7, 6, 3 };
23        for (int i : borderIndices) {
24            int num = grid[row + i / 3][col + (i % 3)];
25            border.append(num);
26        }
27
28        String borderConverted = border.toString();
29        return (
30            grid[row][col] % 2 == 0 &&
31            (grid[row + 1][col + 1] == 5 && sequence.contains(borderConverted) ||
32                sequenceReversed.contains(borderConverted)));
33    }
34}