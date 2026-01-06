// Last updated: 1/6/2026, 11:54:17 PM
1class Solution{    
2    public int minimumJumps(int[] forbidden, int a, int b, int x) {
3      
4        int maxNumPossible = 2000 + 2 * b;
5        
6        boolean[][] visited = new boolean[maxNumPossible][2];
7        boolean[] notAllowed = new boolean[maxNumPossible];
8        
9        for (int forbid : forbidden) notAllowed[forbid] = true;
10        
11        Queue<int[]> q = new LinkedList<>();
12        
13        q.offer(new int[]{0, 0});// [0] = position of jump, [1] = direction of jump
14        int jumps = 0;
15        
16        while (!q.isEmpty()) {
17            
18            int size = q.size();
19            
20            for (int i = 0; i < size; i++) {
21                int[] current = q.poll();
22                int pos = current[0];
23                int dir = current[1];
24                if (pos == x) return jumps;
25                
26                if (pos + a < maxNumPossible &&
27                    !visited[pos+a][0] &&
28                    !notAllowed[pos+a]) {
29
30                    q.offer(new int[]{pos+a, 0});
31                    visited[pos][0] = true;
32                    
33                }
34                
35                if (dir == 0 &&
36                   pos - b >= 0 &&
37                   !visited[pos-b][1] &&
38                    !notAllowed[pos-b]) {
39                    
40                    q.offer(new int[]{pos-b, 1});
41                    visited[pos-b][1] = true;
42                }
43                
44                
45            }
46            
47            jumps++;
48        }
49        
50        return -1;
51    }
52}