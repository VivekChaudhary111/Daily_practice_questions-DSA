// Last updated: 12/23/2025, 4:40:59 PM
1class Solution {
2    public String generateTag(String caption) {
3        String[] strs = caption.trim().split(" ");
4        String result = "";
5        if(strs.length == 0){
6            return "#";
7        }
8        result += "#"+ strs[0].toLowerCase();
9        for(int i = 1; i < strs.length; i++){
10            if(strs[i] == "") continue;
11            result += strs[i].substring(0,1).toUpperCase() + strs[i].substring(1).toLowerCase();
12        }
13        if(result.length() > 100){
14            return result.substring(0,100);
15        }
16        return result;
17    }
18}