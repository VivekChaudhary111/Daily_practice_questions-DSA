// Last updated: 9/8/2025, 5:47:50 PM
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1, b = n-1;
        while(!checkNoZero(a) || !checkNoZero(b)){
            a++;
            b--;
        }
        int[] ans = {a, b};
        return ans;
    }
    public boolean checkNoZero(int x){
        while(x>0){
            int rem = x % 10;
            if(rem == 0) return false;
            x /= 10;
        }
        return true;
    }
}