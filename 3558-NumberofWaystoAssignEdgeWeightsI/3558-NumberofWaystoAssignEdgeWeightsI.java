// Last updated: 6/11/2026, 10:34:54 PM
1class Solution {
2    public int assignEdgeWeights(int[][] edges) {
3        ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
4        for(int i = 0; i <= edges.length; i++) ll.add(new ArrayList());
5        for(int i = 0; i < edges.length; i++){
6            int u = edges[i][0] - 1;
7            int v = edges[i][1] - 1;
8            ll.get(u).add(v);
9            ll.get(v).add(u);
10        }
11        Set<Integer> set = new HashSet<>();
12        Queue<Pair> q = new LinkedList<>();
13        int depth = 0;
14        q.add(new Pair(0, 0));
15        while(!q.isEmpty()){
16            Pair r = q.poll();
17            if(set.contains(r.vtx)) continue;
18            set.add(r.vtx);
19            depth = Math.max(depth, r.hgt);
20            for(int i = 0; i < ll.get(r.vtx).size(); i++){
21                if(!set.contains(ll.get(r.vtx).get(i))){
22                    q.add(new Pair(ll.get(r.vtx).get(i), r.hgt + 1));
23                }
24            }
25        }
26        return qpow(2, depth - 1);
27    }
28    public int qpow(int x, int y) {
29        int MOD = 1_000_000_007;
30        long res = 1;
31        long base = x;
32        while (y > 0) {
33            if ((y & 1) == 1) {
34                res = (res * base) % MOD;
35            }
36            base = (base * base) % MOD;
37            y >>= 1;
38        }
39        return (int) res;
40    }
41    class Pair{
42        int vtx;
43        int hgt;
44        public Pair(int vtx, int hgt){
45            this.vtx = vtx;
46            this.hgt = hgt;
47        }
48    }
49}