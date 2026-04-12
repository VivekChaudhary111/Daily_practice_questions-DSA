// Last updated: 4/12/2026, 8:47:44 AM
1class Solution {
2    public double[] internalAngles(int[] sides) {
3        double a = sides[0];
4        double b = sides[1];
5        double c = sides[2];
6        if(a + b <= c || b + c <= a || a + c <= b){
7            return new double[0];
8        }
9        double[] ans = new double[3];
10        ans[0] = Math.toDegrees(Math.acos((b * b + c * c - a * a)/ (2 * b * c))); 
11        ans[1] = Math.toDegrees(Math.acos((a * a + c * c - b * b)/ (2 * a * c))); 
12        ans[2] = Math.toDegrees(Math.acos((b * b + a * a - c * c)/ (2 * a * b))); 
13        Arrays.sort(ans);
14        return ans;
15    }
16}