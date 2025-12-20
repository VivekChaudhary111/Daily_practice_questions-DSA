// Last updated: 12/20/2025, 8:50:56 PM
1class Solution {
2    public int maximumSum(int[] nums) {
3        List<Integer> num0 = new ArrayList<>();
4        List<Integer> num1 = new ArrayList<>();
5        List<Integer> num2 = new ArrayList<>();
6        for(int num : nums){
7            int rem = num%3;
8            if(rem == 0) num0.add(num);
9            else if(rem == 1) num1.add(num);
10            else num2.add(num);
11        }
12        Collections.sort(num0);
13        Collections.sort(num1);
14        Collections.sort(num2);
15        int s1 = num0.size();
16        int s2 = num1.size();
17        int s3 = num2.size();
18        int n0=0;
19        if(s1 >= 3){
20            n0 += num0.get(s1-1) + num0.get(s1-2) + num0.get(s1-3);
21        }
22        int n1 = 0;
23        if(s1 >= 1 && s2 >= 1 && s3 >= 1){
24            n1 += num0.get(s1-1) + num1.get(s2-1) + num2.get(s3-1);
25        }
26        int n3 = 0;
27        if(s2 >= 3){
28            n3 += num1.get(s2-1) + num1.get(s2-2) + num1.get(s2-3);
29        }
30        int n4 = 0;
31        if(s3 >= 3){
32            n4 += num2.get(s3-1) + num2.get(s3-2) + num2.get(s3-3);
33        }
34        return Math.max(n0, Math.max(n1, Math.max(n4,n3)));
35    }
36}