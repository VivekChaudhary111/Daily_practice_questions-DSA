// Last updated: 12/21/2025, 1:11:07 PM
1class Solution {
2    public boolean isLongPressedName(String name, String typed) {
3        int id1 = 0;
4        int id2 = 0;
5        if(name.charAt(id1) == typed.charAt(id2)){
6            id1++;
7            id2++;
8        }else{
9            return false;
10        }
11        while(id1 < name.length() && id2 < typed.length()){
12            if(name.charAt(id1) == typed.charAt(id2)){
13                id1++;
14                id2++;
15            }else{
16                while(id2 < typed.length() && typed.charAt(id2-1) == typed.charAt(id2)){
17                    id2++;
18                }
19                if(id2 < typed.length() && name.charAt(id1) == typed.charAt(id2)){
20                    id1++;
21                    id2++;
22                }else{
23                    return false;
24                }
25            }
26        }
27        if(id1 < name.length()) return false;
28        for(; id2 < typed.length(); id2++){
29            if(typed.charAt(id2) == typed.charAt(id2-1)) continue;
30            return false;
31        }
32        return true;
33        // for(int i = 0; i < name.length(); ){
34        //     for(; idx < typed.length(); idx++){
35        //         if(typed.charAt(idx) == name.charAt(i)) {
36        //             idx++;
37        //             i++;
38        //             break;
39        //         }
40        //     }
41        //     if(i < name.length() && idx == typed.length()) return false;
42        // }
43        // for(; idx < typed.length(); idx++){
44        //     if(typed.charAt(idx) == typed.charAt(idx-1)) continue;
45        //     return false;
46        // }
47        // return true;
48    }
49}