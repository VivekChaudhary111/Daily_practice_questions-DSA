// Last updated: 10/22/2026, 8:05:01 PM
1class Solution {
2    public int[] lastVisitedCell(char[][] grid) {
3        int oldrow = 0, oldcol = 0;
4        int newrow = 0, newcol = 0;
5        while(isValid(newrow, newcol, grid)){
6            oldrow = newrow;
7            oldcol = newcol;
8            if(grid[newrow][newcol] == 'L'){
9                newcol--;
10            }else if(grid[newrow][newcol] == 'R'){
11                newcol++;
12            }else if(grid[newrow][newcol] == 'U'){
13                newrow--;
14            }else{
15                newrow++;
16            }
17            grid[oldrow][oldcol] = 'X';
18        }
19        return new int[] {oldrow, oldcol};
20    }
21    public boolean isValid(int row, int col, char[][] grid){
22        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 'X'){
23            return false;
24        }
25        return true;
26    }
27}