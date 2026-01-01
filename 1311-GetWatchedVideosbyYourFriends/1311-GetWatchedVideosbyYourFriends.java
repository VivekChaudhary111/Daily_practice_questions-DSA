// Last updated: 1/1/2026, 7:38:17 PM
1class Solution {
2    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
3        int n = friends.length;
4        List<List<Integer>> graph = new ArrayList<>();
5        for(int i = 0 ; i < n; i++){
6            graph.add(new ArrayList<>());
7        }
8        for(int i = 0; i < n; i++){
9            for(int j = 0; j < friends[i].length; j++){
10                graph.get(i).add(friends[i][j]);
11            }
12        }
13        boolean[] isthis = new boolean[n]; 
14        Queue<Pair> q = new LinkedList<>();
15        q.add(new Pair(id, 0));
16        Set<Integer> vis = new HashSet<>();
17        while(!q.isEmpty()){
18            Pair rp = q.poll();
19            if(vis.contains(rp.vtx)) continue;
20            vis.add(rp.vtx);
21            if(rp.cur_level == level){
22                isthis[rp.vtx] = true;
23                continue;
24            }
25            for(int nbrs: graph.get(rp.vtx)){
26                if(!vis.contains(nbrs)){
27                    q.add(new Pair(nbrs, rp.cur_level + 1));
28                }
29            }
30        }
31        Map<String, Integer> ans = new HashMap<>();
32        for(int i = 0 ; i < n; i++){
33            if(isthis[i]){
34                for(String video: watchedVideos.get(i)){
35                    ans.put(video, ans.getOrDefault(video, 0) + 1);
36                }
37            }
38        }
39        List<String> final_ans = new ArrayList<>(ans.keySet());
40        final_ans.sort((a, b)-> ans.get(a) == ans.get(b) ? a.compareTo(b) : ans.get(a)-ans.get(b));
41        return final_ans;
42        
43    }
44    public class Pair{
45        int vtx;
46        int cur_level;
47        public Pair(int vtx, int cur_level){
48            this.vtx = vtx;
49            this.cur_level = cur_level;
50        }
51    }
52}