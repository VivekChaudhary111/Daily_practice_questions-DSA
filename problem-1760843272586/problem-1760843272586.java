// Last updated: 10/19/2025, 8:37:52 AM
class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int maxlen = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]%2==0){
                    set1.add(nums[i]);
                }else{
                    set2.add(nums[i]);
                }
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j]%2==0){
                    set1.add(nums[j]);
                }else{
                    set2.add(nums[j]);
                }
                if(set1.size() == set2.size()){
                    maxlen = Math.max(maxlen, j-i+1);
                }
            }
            set1.clear();
            set2.clear();
        }
        return maxlen;
    }
}