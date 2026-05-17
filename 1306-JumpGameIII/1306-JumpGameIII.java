// Last updated: 5/17/2026, 11:26:57 AM
1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        Queue<Integer> q = new LinkedList<>();
4        boolean[] set = new boolean[arr.length];
5        q.add(start);
6        while(!q.isEmpty()){
7            int r = q.poll();
8            if(set[r]) continue;
9            set[r] = true;
10            if(arr[r] == 0) return true;
11            if(r + arr[r] < arr.length) q.add(r + arr[r]);
12            if(r - arr[r] >= 0) q.add(r - arr[r]);
13        }
14        return false;
15    }
16}