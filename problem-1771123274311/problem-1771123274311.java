// Last updated: 2/15/2026, 8:11:14 AM
1class Solution {
2    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
3        List<Integer> ans = new ArrayList<>();
4        HashSet<Integer> set = new HashSet<>();
5        for(int bulb: bulbs){
6            if(set.contains(bulb)){
7                set.remove(bulb);
8            }else{
9                set.add(bulb);
10            }
11        }
12        for(int bulb: set){
13            ans.add(bulb);
14        }
15        Collections.sort(ans);
16        return ans;
17    }
18}