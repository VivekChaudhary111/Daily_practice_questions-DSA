class Solution {
    public boolean reorderedPowerOf2(int n) {
        int num = getCountNum(n);
        for(int p = 0; p <= 29; p++){ // it's 29 because 2^29 is just less than or equal to 10^9
            if(getCountNum(1 << p) == num){
                return true;
            }
        }
        return false;
    }
    public int getCountNum(int n){
        int num = 0;
        while(n > 0){
            num += Math.pow(10, n%10);
            n /= 10;
        }
        return num;
    }
}
