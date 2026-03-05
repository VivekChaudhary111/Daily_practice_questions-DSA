// Last updated: 3/5/2026, 1:54:36 PM
class Solution {
    public int[] diStringMatch(String s) {
        char[] nums = s.toCharArray();
        int n = s.length();
        int u = n;
        int l = 0;
        int[] arr = new int[n+1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i]  == 'I'){
                arr[i] = l;
                l++;
            }else if (nums[i] == 'D'){
                arr[i] = u;
                u--;
            }
        }
        arr[n] = l;
        return arr;
    }
}