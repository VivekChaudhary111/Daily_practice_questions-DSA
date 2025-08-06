class Solution {
    public int pivotInteger(int n) {
        int total = n*(n+1)/2;
        int pivot = (int) Math.sqrt(total);
        if(pivot*pivot == total){
            return pivot;
        }else{
            return -1;
        }
    }
}
