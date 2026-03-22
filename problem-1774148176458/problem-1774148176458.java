// Last updated: 3/22/2026, 8:26:16 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        Arrays.sort(nums1);
4        if(nums1[0]%2 == 1) return true;
5        for(int i = 0; i < nums1.length; i++){
6            if(nums1[i] % 2 == 1) return false;
7        }
8        return true;
9    }
10}