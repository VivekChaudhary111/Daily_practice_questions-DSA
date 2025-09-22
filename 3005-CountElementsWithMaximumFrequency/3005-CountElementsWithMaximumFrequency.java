// Last updated: 9/22/2025, 8:07:32 AM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxfreq = 0;
        for(int value : map.values()){
            if(value > maxfreq) maxfreq = value;
        }
        int count = 0;
        for(int value : map.values()){
            if(value == maxfreq) count+= maxfreq;
        }
        return count;
    }
}