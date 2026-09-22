// Last updated: 9/23/2026, 12:53:59 AM
1class Solution {
2    public List<List<Integer>> combine(int n, int k) {
3        List<List<Integer>> ans = new ArrayList<>();
4        solve(n, k, 1, ans, new ArrayList<>());
5        return ans;
6    }
7    public void solve(int n, int k, int st, List<List<Integer>> ans, List<Integer> subans){
8        if(k == 0){
9            ans.add(new ArrayList<>(subans));
10            return;
11        }
12        for(int i = st; i <= n; i++){
13            subans.add(i);
14            solve(n, k - 1, i + 1, ans, subans);
15            subans.remove(subans.size() -  1);
16        }
17    }
18}