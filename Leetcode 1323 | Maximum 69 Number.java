class Solution {
    public int maximum69Number (int num) {
        int n = num;
        int count = 0;
        int pos = -1;
        while(n > 0){
            int rem = n%10;
            if(rem == 6){
                pos = count;
            }
            count++;
            n /= 10;
        }
        if(pos != -1){
            return num + (int)Math.pow(10, pos)*3;
        }
        return  num;
    }
}
