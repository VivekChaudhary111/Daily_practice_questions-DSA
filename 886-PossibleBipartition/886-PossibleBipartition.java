// Last updated: 1/3/2026, 11:43:43 PM
1class Solution {
2    public boolean possibleBipartition(int n, int[][] dislikes) {
3        List<List<Integer>> graph = new ArrayList<>();
4        for(int i = 0 ; i < n; i++){
5            graph.add(new ArrayList<>());
6        }
7        for(int i = 0; i < dislikes.length; i++){
8            graph.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
9            graph.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
10        }
11        Queue<BP> q = new LinkedList<>();
12        HashMap<Integer, Integer> visited = new HashMap<>();
13        for(int i = 0; i < n; i++) {
14            if(visited.containsKey(i)) {
15                continue;
16            }
17            q.add(new BP(i, 0));
18            while(!q.isEmpty()) {
19            //	1. remove
20                BP rp = q.poll();
21            //  2. Ignore
22                if(visited.containsKey(rp.vtx)) {
23                    if(visited.get(rp.vtx) != rp.dis) {
24                        return false;
25                    }
26                    continue;
27                }
28            //  3. Marked visited
29                visited.put(rp.vtx, rp.dis);
30            //  4. self work
31            //  5. Add unvisited nbrs
32                for(int nbrs : graph.get(rp.vtx)) {
33                    if(!visited.containsKey(nbrs)) {
34                        q.add(new BP(nbrs, rp.dis + 1));
35                    }
36                }
37            }
38        }
39        return true;
40
41    }
42    public class BP{
43        int vtx;
44        int dis;
45        public BP(int vtx, int dis){
46            this.vtx = vtx;
47            this.dis = dis;
48        }
49    }
50}