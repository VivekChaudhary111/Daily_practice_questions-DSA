// Last updated: 9/23/2026, 12:49:26 AM
1class Solution {
2    public List<List<Integer>> combine(int n, int k) {
3        List<Integer> ll = new ArrayList<>();
4        List<List<Integer>> ans = new ArrayList<>();
5        combinations(n, k, ll, ans, 1);
6        return ans;
7    }
8    public static void combinations(int n, int k, List<Integer> ll, List<List<Integer>> ans, int idx){
9        if(k == 0){
10            ans.add(new ArrayList(ll));
11            return;
12        }
13        for(int i = idx; i <= n; i++){
14            ll.add(i);
15            combinations(n, k - 1, ll, ans, i + 1);
16            ll.remove(ll.size() - 1);
17        }
18    }
19}