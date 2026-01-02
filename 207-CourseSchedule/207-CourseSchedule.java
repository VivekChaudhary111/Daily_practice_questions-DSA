// Last updated: 1/2/2026, 9:30:01 PM
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        HashMap<Integer, List<Integer>> graph = new HashMap<>();
4        for(int i = 0; i < numCourses; i++){
5            graph.put(i, new ArrayList<>());
6        }
7        int[] indegree = new int[numCourses];
8        for(int i = 0; i < prerequisites.length; i++){
9            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
10            indegree[prerequisites[i][0]]++;
11        }
12        Queue<Integer> q = new LinkedList<>();
13        int count = 0;
14        for(int i = 0; i < numCourses; i++){
15            if(indegree[i]==0){
16                q.add(i);
17            }
18        }
19        while(!q.isEmpty()){
20            int rn = q.poll();
21            
22            count++;
23            for(int nbrs: graph.get(rn)){
24                indegree[nbrs]--;
25                if(indegree[nbrs] == 0){
26                    q.add(nbrs);
27                }
28            }
29        }
30        return count == numCourses;
31    }
32}