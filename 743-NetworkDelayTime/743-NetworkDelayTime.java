// Last updated: 3/7/2026, 11:43:35 PM
1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
4        for(int i = 1; i <= n; i++){
5            graph.put(i, new HashMap<>());
6        }
7        for(int[] time: times){
8            graph.get(time[0]).put(time[1], time[2]);
9        }
10        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
11        Set<Integer> set = new HashSet<>();
12        int ans = 0;
13        pq.add(new Pair(k, 0));
14        while(!pq.isEmpty()){
15            Pair rp = pq.poll();
16            if(set.contains(rp.vtx)) continue;
17            set.add(rp.vtx);
18            ans = rp.cost;
19            for(int nbr: graph.get(rp.vtx).keySet()){
20                int cost = graph.get(rp.vtx).get(nbr) + rp.cost;
21                pq.add(new Pair(nbr, cost));
22            }
23        }
24        if(set.size() == n) return ans;
25        return -1;
26    }
27    class Pair{
28        int vtx;
29        int cost;
30        public Pair(int vtx , int cost){
31            this.vtx = vtx;
32            this.cost = cost;
33        }
34    }
35}