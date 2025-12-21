// Last updated: 12/21/2025, 8:16:32 AM
1class Solution {
2    public long minCost(String s, int[] cost) {
3        HashMap<Character, Long> map = new HashMap<>();
4        long total = 0;
5        for(int i = 0; i < s.length(); i++){
6            char ch = s.charAt(i);
7            map.put(ch, map.getOrDefault(ch, (long) 0) + cost[i]);
8            total += cost[i];
9        }
10        long maxval = 0;
11        for(char key : map.keySet()){
12            if(maxval < map.get(key)){
13                maxval = map.get(key);
14            }
15        }
16        return total - maxval;
17        
18    }
19}