// Last updated: 1/3/2026, 12:21:27 AM
1class Solution {
2    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
3        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
4        for(int i = 0; i < n; i++){
5            graph.put(i, new HashMap<>());
6        }
7        for(int i = 0 ; i < edges.length; i++){
8            int u = edges[i][0], v = edges[i][1], cost = edges[i][2];
9            if(u != v){
10                int getcost = graph.get(u).getOrDefault(v, 1000000);
11                if(getcost > cost){
12                    graph.get(u).put(v, cost);
13                    graph.get(v).put(u, cost);
14                }
15            }
16        }
17        int[] ans = new int[n];
18        Arrays.fill(ans, -1);
19        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cur_cost - b.cur_cost);
20        HashSet<Integer> vis = new HashSet<>();
21        pq.add(new Pair(0, 0));
22        while(!pq.isEmpty()){
23            Pair rp = pq.poll();
24
25            if(vis.contains(rp.vtx)) continue;
26
27            vis.add(rp.vtx);
28
29            ans[rp.vtx] = rp.cur_cost;
30
31            for(int nbrs: graph.get(rp.vtx).keySet()){
32                if(!vis.contains(nbrs)){
33                    int cost = graph.get(rp.vtx).get(nbrs);
34                    if(rp.cur_cost + cost < disappear[nbrs]){
35                        pq.add(new Pair(nbrs, cost + rp.cur_cost));
36                    }
37                }
38            }
39        }
40        return ans;
41    }
42    public class Pair{
43        int vtx;
44        int cur_cost;
45        public Pair(int vtx, int cur_cost){
46            this.vtx = vtx;
47            this.cur_cost = cur_cost;
48        }
49    }
50}