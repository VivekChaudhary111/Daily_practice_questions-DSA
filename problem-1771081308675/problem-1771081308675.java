// Last updated: 2/14/2026, 8:31:48 PM
1class Solution {
2    public int prefixConnected(String[] words, int k) {
3        HashMap<String, Integer> map = new HashMap<>();
4        int cnt = 0;
5        for(String s : words){
6            if(s.length() >= k){
7                String sub = s.substring(0, k);
8                if(map.containsKey(sub) && map.get(sub) == 1){
9                    cnt++;
10                }
11                map.put(sub, map.getOrDefault(sub, 0) + 1);
12            }
13        }
14        return cnt;
15    }
16}