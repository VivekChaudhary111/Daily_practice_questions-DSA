// Last updated: 10/10/2025, 11:11:35 PM
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] suffix = new int[energy.length];
        for(int i = suffix.length-1; i >= 0; i--){
            if(i + k < suffix.length){
                suffix[i] = energy[i] + suffix[i+k];
            }else{
                suffix[i] = energy[i];
            }
        }
        int max = suffix[0];
        for(int i = 1; i < suffix.length; i++){
            max = Math.max(max, suffix[i]);
        }
        return max;
    }
}