// Last updated: 1/30/2026, 12:58:58 PM
1class Solution {
2    public int findTheWinner(int n, int k) {
3        Queue<Integer> q = new LinkedList<>();
4        int i =1;
5        while(i <= n){
6            q.add(i);
7            i++;
8        }
9        int curr = 1;
10        while(q.size() > 1){
11            int num = q.poll();
12            if(curr == k){
13                curr = 1;
14                continue;
15            }
16            q.add(num);
17            curr++;
18        }
19        return q.poll();
20    }
21}