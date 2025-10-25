// Last updated: 10/25/2025, 3:34:22 PM
class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int weeks = n/7;
        ans += (weeks/2.0)*(2*(28) + (weeks-1)*7);
        n = n%7;
        ans += (n/2.0)*(2*(weeks+1) + (n-1));
        return ans;
    }
}