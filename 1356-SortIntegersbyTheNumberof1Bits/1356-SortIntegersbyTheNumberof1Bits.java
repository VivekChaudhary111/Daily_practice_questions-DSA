// Last updated: 2/26/2026, 3:58:09 AM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        int a[][] = new int[arr.length][2];
4        int b[] = new int[arr.length];
5        for (int i = 0; i < arr.length; i++) {
6            a[i][0] = arr[i];
7            a[i][1] = Integer.bitCount(arr[i]);
8        }
9        Arrays.sort(a, (c, d) ->{
10            if(c[1]==d[1]){
11                return Integer.compare(c[0],d[0]);
12            }
13        return Integer.compare(c[1], d[1]);});
14        
15        for (int j = 0; j < arr.length; j++) {
16            arr[j] = a[j][0];
17        }
18        return arr;
19    }
20}