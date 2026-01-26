// Last updated: 1/26/2026, 11:57:54 PM
1class Solution {
2    private boolean[] prime;
3    private void sieve(int n){
4        prime=new boolean[n+1];
5        Arrays.fill(prime,true); 
6        prime[1]=false;
7        for(int p=2;p*p<=n;p++) if(prime[p]) for(int i=p*p;i<=n;i+=p) prime[i]=false;
8    }
9    public int primeSubarray(int[] nums, int k) {
10        int n=nums.length,max=0;
11        for(int num:nums) max=Math.max(max,num);
12        TreeMap<Integer,Integer> map=new TreeMap<>();
13        int primes=0,l1=0,l2=0;
14        sieve(max);
15        int cntK=0,cnt1=0;
16        for(int r=0;r<n;r++){
17            if(prime[nums[r]]){
18                primes++;
19                map.put(nums[r],map.getOrDefault(nums[r],0)+1); 
20            }
21            while(primes>1){
22                if(prime[nums[l1]]) primes--;
23                l1++;
24            }
25            while(!map.isEmpty()&&map.lastKey()-map.firstKey()>k){
26                if(prime[nums[l2]]){
27                    map.put(nums[l2],map.get(nums[l2])-1);
28                    if(map.get(nums[l2])==0) map.remove(nums[l2]);
29                }
30                l2++;
31            }
32            cnt1+=(r-l1+1);
33            cntK+=(r-l2+1);
34        }
35        return cntK-cnt1;
36    }
37}