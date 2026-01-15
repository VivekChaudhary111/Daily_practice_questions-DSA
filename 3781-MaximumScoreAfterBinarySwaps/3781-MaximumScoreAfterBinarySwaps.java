// Last updated: 1/16/2026, 12:00:14 AM
1class Solution {
2    public long maximumScore(int[] nums, String s) {
3        long ans=0;
4        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
5        for(int i=0;i<s.length();i++)
6            {
7                pq.offer(nums[i]);
8                if(s.charAt(i)=='1')
9                {
10                    int top=pq.poll();
11                    ans+=top;
12                }
13            }
14        return ans;
15    }
16}