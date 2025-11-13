// Last updated: 11/13/2025, 7:40:40 AM
class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int[] arr = new int[n+1];
        if(s.charAt(0) == '1'){
            arr[1] = 1;
        }
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '1'){
                arr[i+1] = 1 + arr[i];
            }else{
                arr[i+1] = arr[i];
            }
        }
        int ops = 0;
        if(s.charAt(n-1) == '0'){
            ops += arr[n-1];
        }
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0' && s.charAt(i+1) != '0'){
                ops += arr[i];
            }
        }
        return ops;
    }
}