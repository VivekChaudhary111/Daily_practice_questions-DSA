// Last updated: 9/23/2026, 12:01:48 AM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> ans = new ArrayList<>();
4        solve(candidates, target, 0, ans, new ArrayList<>());
5        return ans;
6    }
7    public void solve(int[] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> subans){
8        if(target == 0){
9            ans.add(new ArrayList<>(subans));
10            return;
11        }
12        for(int i = idx; i < candidates.length; i++){
13            if(candidates[i] <= target){
14                subans.add(candidates[i]);
15                solve(candidates, target-candidates[i], i, ans, subans);
16                subans.remove(subans.size() - 1);
17            }
18        }
19    }
20}