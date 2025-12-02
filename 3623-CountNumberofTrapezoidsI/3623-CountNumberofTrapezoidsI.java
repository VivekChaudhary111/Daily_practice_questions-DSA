// Last updated: 12/3/2025, 12:53:11 AM
1class Solution {
2    public int countTrapezoids(int[][] points) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        for(int[] point : points){
5            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
6        }
7        long ans = 0;
8        long prefix = 0;
9        for(int Npoints : map.values()){
10            long edges = ((long)Npoints*(Npoints-1))/2;
11            ans = (ans + edges*prefix)%1000000007;
12            prefix = (prefix + edges)%1000000007;
13        }
14        
15        return (int) ans;
16    }
17}