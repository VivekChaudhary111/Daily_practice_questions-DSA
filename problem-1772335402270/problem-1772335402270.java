// Last updated: 3/1/2026, 8:53:22 AM
1class Solution {
2    public int minimumOR(int[][] grid) {
3        int res = (1 << 18) - 1;
4        for(int i = 17; i >= 0; i--){
5            int mask = res ^ (1 << i);
6            boolean isValid = true;
7            for(int[] r : grid){
8                boolean isValidRow = false;
9                for(int num : r){
10                    if((num | mask) == mask){
11                        isValidRow = true;
12                        break;
13                    }
14                }
15                if(!isValidRow){
16                    isValid = false;
17                    break;
18                }
19            }
20            if(isValid){
21                res = mask;
22            }
23        }
24        return res;
25    }
26}