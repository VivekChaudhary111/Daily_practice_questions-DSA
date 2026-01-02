// Last updated: 1/3/2026, 12:55:51 AM
1class Solution {
2    public int secondMinimum(int n, int[][] edges, int time, int change) {
3        List<List<Integer>> graph = new ArrayList<>();
4        for(int i = 0; i <= n; i++){
5            graph.add(new ArrayList<>());
6        }
7        for(int i = 0; i < edges.length; i++){
8            int u = edges[i][0], v = edges[i][1];
9            graph.get(u).add(v);
10            graph.get(v).add(u);
11        }
12        int[][] dist = new int[n+1][2]; 
13        for(int[] a : dist){
14            Arrays.fill(a, Integer.MAX_VALUE);
15        }
16        dist[0][0] = 0;
17        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.cur_time - b.cur_time);
18        q.add(new Pair(0, 1));
19        while(!q.isEmpty()){
20            Pair rp = q.poll();
21            int ct = rp.cur_time;
22            for(int nbrs : graph.get(rp.vtx)){
23                int t = ct;
24                if((ct/change)%2 == 1){
25                    t = (t/change+1)*change;
26                }
27                int newtime =  t + time;
28                if(newtime < dist[nbrs][0]){
29                    dist[nbrs][1] = dist[nbrs][0];
30                    dist[nbrs][0] = newtime;
31                    q.add(new Pair(newtime, nbrs));
32                }else if(newtime > dist[nbrs][0] && newtime < dist[nbrs][1]){
33                    dist[nbrs][1] = newtime;
34                    q.add(new Pair(newtime, nbrs));
35                }
36            }
37        }
38        return dist[n][1];
39    }
40    public class Pair{
41        int cur_time;
42        int vtx;
43        public Pair(int cur_time, int vtx){
44            this.cur_time = cur_time;
45            this.vtx = vtx;
46        }
47    }
48}