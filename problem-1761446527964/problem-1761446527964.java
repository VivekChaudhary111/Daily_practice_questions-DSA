// Last updated: 10/26/2025, 8:12:07 AM
class Solution {
    public long removeZeros(long n) {
        long result1 = 0;
        long result2 = 0;
        while(n>0){
            long num = n%10;
            if(num != 0){
                result1 = result1*10 + num;
            }
            n = n/10;
        }
        while(result1>0){
            result2 = result2*10 + result1%10;
            result1 = result1/10;
        }
        return result2;
        
    }
}