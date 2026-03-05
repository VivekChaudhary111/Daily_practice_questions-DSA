// Last updated: 3/5/2026, 11:25:58 PM
1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
3        HashMap<Integer, List<Integer>> graph = new HashMap<>();
4        int[] ans = new int[numCourses];
5        int[] in = new int[numCourses];
6        for(int i = 0 ; i < numCourses; i++){
7            graph.put(i, new ArrayList<>());
8        }
9        for(int[] pre :  prerequisites){
10            graph.get(pre[1]).add(pre[0]);
11            in[pre[0]]++;
12        }
13        Queue<Integer> q = new LinkedList<>();
14        for(int i = 0; i < in.length; i++){
15            if(in[i] == 0) q.add(i);
16        }
17        int idx = 0;
18        while(!q.isEmpty()){
19            int rn = q.poll();
20            ans[idx++] = rn;
21            for(int nbr : graph.get(rn)){
22                in[nbr]--;
23                if(in[nbr] == 0) q.add(nbr);
24            }
25        }
26        if(idx == numCourses){
27            return ans;
28        }
29        return new int[]{};
30    }
31}