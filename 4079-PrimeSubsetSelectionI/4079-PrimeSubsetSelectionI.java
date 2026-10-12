// Last updated: 10/12/2026, 11:52:10 PM
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
13                    for(int j = 2; j*i <= n; j++){
14                        notPrime[i*j] = true;
15                    }
16                }else{
17                    break;
18                }
19            }
20        }
21        return ans;
22    }
23}