// Last updated: 11/30/2025, 9:17:34 AM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        int mindiff = Integer.MAX_VALUE;
5        for(int i = nums.length - 1; i >= 0; i--){
6            int rev = reverse(nums[i]);
7            if(map.containsKey(rev)){
8                int j = map.get(rev);
9                mindiff = Math.min(mindiff, Math.abs(j - i));
10                if(mindiff == 1) return 1;
11            }else{
12                map.put(nums[i], i);
13            }
14        }
15        return mindiff == Integer.MAX_VALUE ? -1 : mindiff;
16    }
17    public static int reverse(int num){
18        int nnum = 0;
19        while(num > 0){
20            int rem = num % 10;
21            num  /= 10;
22            nnum = nnum*10 + rem;
23        }
24        return nnum;
25    }
26}