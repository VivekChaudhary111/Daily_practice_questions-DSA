// Last updated: 12/30/2025, 11:59:45 PM
1
2public class Solution {
3    public int closestMeetingNode(int[] edges, int node1, int node2) {
4        int[] dist1 = getDistances(edges, node1);
5        int[] dist2 = getDistances(edges, node2);
6
7        int result = -1;
8        int minDistance = Integer.MAX_VALUE;
9
10        for (int i = 0; i < edges.length; i++) {
11            if (dist1[i] != -1 && dist2[i] != -1) {
12                int maxDist = Math.max(dist1[i], dist2[i]);
13                if (maxDist < minDistance) {
14                    minDistance = maxDist;
15                    result = i;
16                }
17            }
18        }
19        return result;
20    }
21
22    public int[] getDistances(int[] edges, int start) {
23        int n = edges.length;
24        int[] dist = new int[n];
25        java.util.Arrays.fill(dist, -1);
26        int d = 0;
27        while (start != -1 && dist[start] == -1) {
28            dist[start] = d++;
29            start = edges[start];
30        }
31        return dist;
32    }
33}
34