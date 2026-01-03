// Last updated: 1/4/2026, 12:34:25 AM
1class Solution {
2    public int findChampion(int n, int[][] edges) {
3        List<List<Integer>> graph = new ArrayList<>();
4        for(int i = 0; i < n; i++){
5            graph.add(new ArrayList<>());
6        }
7        int[] indegree = new int[n];
8        for(int i = 0; i < edges.length; i++){
9            graph.get(edges[i][0]).add(edges[i][1]);
10            indegree[edges[i][1]]++;
11        }
12        Queue<Integer> q = new LinkedList<>();
13        for(int i = 0; i < n; i++){
14            Set<Integer> vis = new HashSet<>();
15            if(indegree[i]==0){
16                q.add(i);
17            }
18            while(!q.isEmpty()){
19                int rn = q.poll();
20                if(vis.contains(rn)) continue;
21                vis.add(rn);
22                for(int nbrs: graph.get(rn)){
23                    if(!vis.contains(nbrs)) q.add(nbrs);
24                }
25            }
26            if(vis.size() == n) return i;
27        }
28        return -1;
29    }
30}