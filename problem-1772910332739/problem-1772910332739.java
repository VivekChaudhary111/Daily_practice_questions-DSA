// Last updated: 3/8/2026, 12:35:32 AM
1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
4        for(int i = 0; i < n; i++){
5            graph.put(i, new HashMap<>());
6        }
7        for(int[] flight: flights){
8            graph.get(flight[0]).put(flight[1], flight[2]);
9        }
10        int[] minStops = new int[n];
11        Arrays.fill(minStops, Integer.MAX_VALUE);
12        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
13        pq.add(new Pair(src, 0, 0));
14        int ans = Integer.MAX_VALUE;
15        while(!pq.isEmpty()){
16            Pair rp = pq.poll();
17            if(rp.stops - 1 > k) continue;
18            if(rp.stops > minStops[rp.vtx]) continue;
19            minStops[rp.vtx] = rp.stops;
20            if(rp.vtx == dst) return rp.cost;
21            for(int nbr: graph.get(rp.vtx).keySet()){
22                int cost = graph.get(rp.vtx).get(nbr) + rp.cost;
23                pq.add(new Pair(nbr, cost, rp.stops + 1));
24            }
25        }
26        if(ans != Integer.MAX_VALUE) return ans;
27        return -1;
28    }
29    class Pair{
30        int vtx;
31        int cost;
32        int stops;
33        public Pair(int vtx, int cost, int stops){
34            this.vtx = vtx;
35            this.cost = cost; 
36            this.stops = stops;
37        }
38    }
39}