// Last updated: 3/9/2026, 2:06:02 AM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        Set<Integer> integers = new HashSet();
4        for (String num : nums) {
5            integers.add(Integer.parseInt(num, 2));
6        }
7        
8        int n = nums.length;
9        for (int num = 0; num <= n; num++) {
10            if (!integers.contains(num)) {
11                String ans = Integer.toBinaryString(num);
12                while (ans.length() < n) {
13                    ans = "0" + ans;
14                }
15                
16                return ans;
17            }
18        }
19        
20        return "";
21    }
22}