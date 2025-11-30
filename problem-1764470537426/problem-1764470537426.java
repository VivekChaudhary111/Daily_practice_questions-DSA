// Last updated: 11/30/2025, 8:12:17 AM
1class Solution {
2    public int countElements(int[] nums, int k) {
3        if (k == 0){
4            return nums.length;
5        }
6        int count = 0;
7        Arrays.sort(nums);
8        for(int i = 0; i < nums.length; i++){
9            int idx = BSearch(i, nums);
10            if(idx == -1){
11                break;
12            }
13            if(nums.length - idx >= k){
14                count++;
15            }
16        }
17        return count;
18    }
19    public static int BSearch(int i, int[] nums){
20        int idx = -1;
21        int low = i + 1;
22        int high = nums.length - 1;
23        while(low <= high){
24            int mid = low + (high - low)/2;
25            if(nums[mid]>nums[i]){
26                idx = mid;
27                high = mid - 1;
28            }else{
29                low = mid + 1;
30            }
31        }
32        return idx;
33    }
34}