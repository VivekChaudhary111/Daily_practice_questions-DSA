// Last updated: 9/12/2025, 3:50:07 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
    int count = 0;
    int prefixSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // Important: handle case where prefixSum == k
    
    for (int num : nums) {
        prefixSum += num;
        
        // Check if (prefixSum - k) exists
        if (map.containsKey(prefixSum - k)) {
            count += map.get(prefixSum - k);
        }
        
        // Add current prefixSum to map
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }
    
    return count;
}

}