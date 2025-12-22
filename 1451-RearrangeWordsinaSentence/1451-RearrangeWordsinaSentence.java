// Last updated: 12/23/2025, 12:34:16 AM
1class Solution {
2    public String arrangeWords(String text) {
3        String[] strs = text.trim().split(" ");
4        if(strs == null || strs.length == 0){
5            return "";
6        }
7        Arrays.sort(strs, (a, b) -> a.length() - b.length());
8        StringBuilder sb = new StringBuilder();
9        sb.append(strs[0].substring(0,1).toUpperCase() + strs[0].substring(1)+" ");
10        for(int i = 1; i<strs.length; i++){
11            sb.append(strs[i].toLowerCase()+" ");
12        }
13        return sb.toString().trim();
14    }
15}