// Last updated: 3/1/2026, 6:51:28 PM
1class Solution {
2    public int minPartitions(String n) {
3        int maxi=0;
4        for(int i=0; i<n.length(); i++){
5            int dig=n.charAt(i)-'0';
6            maxi=Math.max(maxi,dig);
7        }
8        return maxi;
9    }
10}