// Last updated: 11/16/2025, 12:55:12 PM
class Solution {
    static int mod=(int)Math.pow(10,9)+7;
    public int numSub(String s) {
       int cnt = 0;
       int j=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='0'){
            j=i+1;
        }
        else{
            cnt=(cnt+(i-j+1))%mod;
        }
       }
       return cnt%mod;
    }
}