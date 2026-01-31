// Last updated: 1/31/2026, 8:38:46 PM
1class Solution {
2    public int minimumK(int[] nums) {
3        int low = 1;
4        int high = 100000;
5        int ans = -1;
6        while(low <= high){
7            int mid = low + (high-low)/2;
8            if(isPossible(nums, mid)){
9                ans = mid;
10                high = mid - 1;
11            }else{
12                low = mid + 1;
13            }
14        }
15        return ans;
16    }
17    public boolean isPossible(int[] nums, int k){
18        long ops = 0;
19        for(int num: nums){
20            ops += (int)Math.ceil(num/(double)k);
21        }
22        if((long) ops <= (long) k*k) return true;
23        return false;
24    }
25}