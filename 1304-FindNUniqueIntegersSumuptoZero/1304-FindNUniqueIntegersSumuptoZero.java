// Last updated: 9/8/2025, 1:49:50 AM
class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        if(n%2 != 0){
            arr[0] = 0;
            if(n == 1) return arr;
            n--;
        }
        int multiplicant = 1;
        for(int i = 0; i < n; i++){
            arr[i] = ((i+2)/2)*multiplicant;
            multiplicant *= -1;
        }
        return arr;
    }
}