// Last updated: 12/22/2025, 5:42:58 PM
1class Solution {
2    public String generateTag(String caption) {
3        String[] strs = caption.split(" ");
4        String result = "";
5        if(strs.length == 0){
6            return "#";
7        }
8        int idx = 0;
9        while(strs[idx] == "") idx++;
10        result += "#"+ strs[idx].toLowerCase();
11        for(int i = idx+1; i < strs.length; i++){
12            if(strs[i] == "") continue;
13            result += strs[i].substring(0,1).toUpperCase() + strs[i].substring(1).toLowerCase();
14        }
15        if(result.length() > 100){
16            return result.substring(0,100);
17        }
18        return result;
19    }
20}