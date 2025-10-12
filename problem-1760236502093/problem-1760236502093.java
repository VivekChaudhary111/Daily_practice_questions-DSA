// Last updated: 10/12/2025, 8:05:02 AM
class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int sum = 0;
        for(int key: map.keySet()){
            if(map.get(key)%k == 0) sum += map.get(key)*key;
        }
        return sum;
    }
}