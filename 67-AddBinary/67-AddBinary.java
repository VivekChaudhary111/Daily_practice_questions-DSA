// Last updated: 2/16/2026, 3:38:39 AM
1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder sb = new StringBuilder();
4        char carry = '0';
5        int len1= a.length()-1, len2 = b.length()-1;
6        while(len1 >= 0 && len2 >= 0){
7            char ch1 = a.charAt(len1);
8            char ch2 = b.charAt(len2);
9            if(carry == '1'){
10                if(ch1 == '1' && ch2 == '1'){
11                    sb.append('1');
12                }else if(ch1 == '1' || ch2 == '1'){
13                    sb.append('0');
14                }else{
15                    sb.append('1');
16                    carry = '0';
17                }
18            }else{
19                if(ch1 == '1' && ch2 == '1'){
20                    sb.append('0');
21                    carry = '1';
22                }else if(ch1 == '1' || ch2 == '1'){
23                    sb.append('1');
24                }else{
25                    sb.append('0');
26                }
27
28            }
29            len1--;
30            len2--;
31        }
32        while(0 <= len1){
33            if(a.charAt(len1) == '1' && carry == '1'){
34                sb.append('0');
35            }else if(a.charAt(len1) == '1'){
36                sb.append('1');
37            }else if(carry == '1'){
38                sb.append('1');
39                carry = '0';
40            } else{
41                sb.append('0');
42            }
43            len1--;
44        }
45        while(0 <= len2){
46            if(b.charAt(len2) == '1' && carry == '1'){
47                sb.append('0');
48            }else if(b.charAt(len2) == '1'){
49                sb.append('1');
50            }else if(carry == '1'){
51                sb.append('1');
52                carry = '0';
53            } else{
54                sb.append('0');
55            }
56            len2--;
57        }
58        if(carry == '1'){
59            sb.append('1');
60        }
61        return sb.reverse().toString();
62       
63    }
64}