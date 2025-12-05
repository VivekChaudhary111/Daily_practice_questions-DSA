// Last updated: 12/5/2025, 9:36:21 AM
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
11            }map.put(nums[i], i);
12        }
13        return mindiff == Integer.MAX_VALUE ? -1 : mindiff;
14    }
15    public static int reverse(int num){
16        int nnum = 0;
17        while(num > 0){
18            int rem = num % 10;
19            num  /= 10;
20            nnum = nnum*10 + rem;
21        }
22        return nnum;
23    }
24}