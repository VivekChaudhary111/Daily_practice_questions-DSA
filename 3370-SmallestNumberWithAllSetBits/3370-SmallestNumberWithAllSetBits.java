// Last updated: 10/29/2025, 6:37:23 AM
class Solution {
    public int smallestNumber(int n) {
        int low = 0;
        int high = n;
        int ans = 0;
        while(low<=high){
            int mid = (high+low)/2;
            if(((int)Math.pow(2, mid))-1 >= n){
                ans =  ((int)Math.pow(2, mid))-1;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}