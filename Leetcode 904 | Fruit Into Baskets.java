class Solution {
    public int totalFruit(int[] fruits) {
        int prev = -1, prev2 = -1;
        int prevcount = 0;
        int ans = 0;
        int subans = 0;
        for(int i = 0; i < fruits.length; i++){
            if(fruits[i] == prev || fruits[i] == prev2){
                subans++;
            }else{
                ans = Math.max(ans, subans);
                subans = prevcount + 1;
            }
            if(fruits[i] == prev){
                prevcount++;
            }else{
                prevcount = 1;
                prev2 = prev;
                prev = fruits[i];
            }
        }
        return Math.max(ans, subans);
    }
}
