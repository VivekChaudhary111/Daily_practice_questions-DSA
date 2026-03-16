// Last updated: 3/16/2026, 4:35:10 PM
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        List<List<Integer>> ans = new ArrayList<>();
4        List<Integer> subans = new ArrayList<>();
5        Arrays.sort(candidates);
6        solve(candidates, target, 0, ans, subans);
7        return ans;
8    }
9    public static void solve(int[] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> subans){
10        if(target == 0) {
11            ans.add(new ArrayList<>(subans));
12            return;
13        }
14        if(idx == candidates.length || target < 0) return;
15        for(int i = idx; i < candidates.length; i++){
16            if(i > idx && candidates[i] == candidates[i-1]) continue;
17            subans.add(candidates[i]);
18            solve(candidates, target - candidates[i], i+1, ans, subans);
19            subans.remove(subans.size() - 1);
20        }
21    }
22}