// Last updated: 10/13/2026, 12:06:51 AM
1class Solution {
2    public List<Integer> maxPrimes(int n, int s) {
3        List<Integer> ans = new ArrayList<>();
4        int sum = 0;
5        boolean[] notPrime = new boolean[n + 1];
6        notPrime[0] = true;
7        notPrime[1] = true;
8        for(int i = 2; i <= n; i++){
9            if(notPrime[i] == false){
10                if(i + sum <= s) {
11                    ans.add(i);
12                    sum += i;
13                    for(int j = i*i;j >=0 && j <= n; j += i){
14                        notPrime[j] = true;
15                    }
16                }else{
17                    break;
18                }
19            }
20        }
21        return ans;
22    }
23}