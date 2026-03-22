// Last updated: 3/22/2026, 9:31:31 AM
1class Solution {
2    public int minRemovals(int[] nums, int target) {
3        int n = nums.length;
4        int mid = n/2;
5        int[] left = Arrays.copyOfRange(nums, 0, mid);
6        int[] right = Arrays.copyOfRange(nums, mid, n);
7
8        Map<Integer, Integer> map = new HashMap<>();
9        for(int mask = 0; mask < (1 << left.length); mask++){
10            int xor = 0, count = 0;
11            for(int i = 0; i < left.length; i++){
12                if((mask & (1 << i)) != 0){
13                    xor ^= left[i];
14                    count++;
15                }
16            }
17            map.put(xor, Math.max(count, map.getOrDefault(xor, 0)));
18        }
19        int length = -1;
20        for(int mask = 0; mask < (1 << right.length); mask++){
21            int xor = 0, count = 0;
22            for(int i = 0; i < right.length; i++){
23                if((mask & (1 << i)) != 0){
24                    xor ^= right[i];
25                    count++;
26                }
27            }
28            int need = target ^ xor;
29            if(map.containsKey(need)){
30                length = Math.max(length, map.get(need) + count);
31            }
32        }
33        if(length == -1) return -1;
34        return n - length;
35    }
36}