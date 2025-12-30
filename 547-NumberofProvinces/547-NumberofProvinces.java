// Last updated: 12/30/2025, 11:49:37 PM
1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int n = isConnected.length;
4        HashMap<Integer, List<Integer>> graph = new HashMap<>();
5        for(int i = 0; i < n; i++){
6            graph.put(i, new ArrayList<>());
7        }
8        for(int i = 0; i < n; i++){
9            for(int j = 0; j < n; j++){
10                if(isConnected[i][j] == 1){
11                    graph.get(i).add(j);
12                }
13            }
14        }
15        Queue<Integer> q = new LinkedList<>();
16        Set<Integer> vis = new HashSet<>();
17        int cnt =0;
18        for(int i = 0; i < n; i++){
19            if(vis.contains(i)) continue;
20            cnt++;
21            q.add(i);
22            while(!q.isEmpty()){
23                int rn = q.poll();
24                vis.add(rn);
25                for(int nbrs: graph.get(rn)){
26                    if(!vis.contains(nbrs)){
27                        q.add(nbrs);
28                    }
29                }
30            }
31        }
32        return cnt;
33    }
34}