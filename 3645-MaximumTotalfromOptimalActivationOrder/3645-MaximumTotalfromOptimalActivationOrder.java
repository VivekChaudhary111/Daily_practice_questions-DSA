// Last updated: 1/23/2026, 11:58:36 PM
1class Solution {
2    public long maxTotal(int[] value, int[] limit) {
3        int n = value.length;
4        HashMap<Integer,PriorityQueue<Integer>> mp = new HashMap<>();
5        for(int i = 0; i<n; i++){
6            int lim = limit[i];
7            mp.putIfAbsent(lim,new PriorityQueue<>());
8            PriorityQueue<Integer> pq = mp.get(lim);
9            pq.add(value[i]);
10            if(pq.size() > lim){
11                pq.poll();
12            }
13        }
14
15        long ans = 0;
16        for(int key : mp.keySet()){
17            PriorityQueue<Integer> pq = mp.get(key);
18            while(!pq.isEmpty()){
19                ans += pq.poll();
20            }
21        }
22        return ans;
23    }
24}