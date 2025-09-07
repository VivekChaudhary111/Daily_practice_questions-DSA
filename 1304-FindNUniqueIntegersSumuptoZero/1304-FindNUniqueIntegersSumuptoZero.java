// Last updated: 9/8/2025, 1:51:25 AM
class Solution {
    public int[] sumZero(int n) {
        int[] arr=new int[n];
        int sum=0;
        for(int i=0;i<n-1;i++)
        {
            arr[i]=i+1;
            sum+=arr[i];
        }
        arr[n-1]=0-sum;
        return arr;
    }
}