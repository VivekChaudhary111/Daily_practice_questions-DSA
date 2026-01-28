// Last updated: 1/28/2026, 11:57:33 PM
1class Solution {
2    public int[] countRectangles(int[][] rectangles, int[][] points) {
3        Arrays.sort(rectangles, (a,b)->{
4            return a[0] - b[0];
5        });
6        
7        List<List<Integer>> yList = new ArrayList<>();
8        for(int y=0;y<=100;y++)
9            yList.add(new ArrayList<>());
10        
11        for(int i=0;i<rectangles.length;i++){
12            int[] rect = rectangles[i];
13            int x = rect[0];
14            int y = rect[1];
15            
16            List<Integer> xList = yList.get(y);
17            xList.add(x);
18        }
19        
20        int[] ans = new int[points.length];
21        
22        for(int i=0;i<points.length;i++){
23            int[] p = points[i];
24            
25            for(int y=p[1]; y<=100; y++){
26                List<Integer> xList = yList.get(y);
27                if(xList.isEmpty())
28                    continue;
29                int index = Collections.binarySearch(xList, p[0]);
30                
31                ans[i] += xList.size() - (index >= 0 ? index : -index-1);
32            }
33        }
34        
35        return ans;
36    }
37}