// Last updated: 1/9/2026, 10:29:27 AM
1class Solution {
2    public List<List<Integer>> findWinners(int[][] matches) {
3        TreeMap<Integer, Integer> map = new TreeMap<>();
4        for(int[] a : matches){
5            map.put(a[0], map.getOrDefault(a[0], 0));
6            map.put(a[1], map.getOrDefault(a[1], 0) + 1);
7        }
8        List<List<Integer>> ans = new ArrayList<>();
9        ans.add(new ArrayList<>());
10        ans.add(new ArrayList<>());
11        for(int key: map.keySet()){
12            if(map.get(key) == 0){
13                ans.get(0).add(key);
14            }else if(map.get(key) == 1){
15                ans.get(1).add(key);
16            }
17        }
18        return ans;
19    }
20}