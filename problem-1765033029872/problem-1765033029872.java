// Last updated: 12/6/2025, 8:27:09 PM
1class Solution {
2    public boolean completePrime(int num) {
3        if(num == 1) return false;
4        if(!reverse(num)) return false;
5        while(num > 0){
6            if(!check(num)) return false;
7            num /= 10;
8        }
9        return true;
10    }
11    public static boolean reverse(int num){
12        int newnum = 0, factor = 1;
13        while(num > 0){
14            int rem = num%10;
15            newnum = rem*factor + newnum;
16            factor *= 10;
17            if (!check(newnum)) return false;
18            num /= 10;
19        }
20        return true;
21    }
22    public static boolean check(int num) {
23        if (num <= 1) return false; 
24        if (num == 2) return true;  
25        if (num % 2 == 0) return false; 
26        
27        for (int i = 3; i * i <= num; i += 2) {
28            if (num % i == 0) return false;
29        }
30        return true;
31    }
32}