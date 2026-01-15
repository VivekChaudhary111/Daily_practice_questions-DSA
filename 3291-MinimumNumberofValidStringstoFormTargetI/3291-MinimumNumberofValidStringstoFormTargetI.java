// Last updated: 1/15/2026, 11:59:00 PM
1class Trie{
2    List<List<Integer>> list;
3    public Trie(){
4        list = new ArrayList<>();
5        
6        list.add(new ArrayList<>());
7        for(int i=0; i<26; i++){
8            list.get(0).add(-1);
9        }
10    }
11    
12    public void insert(String word){
13        int curr = 0;
14        for(char ch:word.toCharArray()){
15            int idx = ch-'a';
16            if(list.get(curr).get(idx)==-1){
17                list.get(curr).set(idx, list.size());
18                
19                List<Integer> newl = new ArrayList<>();
20                for(int i=0; i<26; i++){
21                    newl.add(-1);
22                }
23                list.add(newl);
24            }
25            curr = list.get(curr).get(idx);
26        }
27    }
28    
29    public int findPrefix(String target, int start, int[] dp){
30        int current = 0;
31        for (int i = start; i < target.length(); i++) {
32            int index = target.charAt(i) - 'a';
33            if (list.get(current).get(index) == -1) {
34                return -1;
35            }
36            current = list.get(current).get(index);
37            dp[i + 1] = Math.min(dp[i + 1], dp[start] + 1);
38        }
39        return dp[target.length()];
40    }
41}
42
43
44class Solution{
45    public int minValidStrings(String[] words, String target) {
46        Trie trie = new Trie();
47        for(String word:words){
48            trie.insert(word);
49        }
50        
51        int[] dp = new int[target.length()+1];
52        Arrays.fill(dp, Integer.MAX_VALUE);
53        
54        dp[0]=0;
55        for(int i=0; i<target.length(); i++){
56            if(dp[i]!=Integer.MAX_VALUE){
57                trie.findPrefix(target, i, dp);
58            }
59        }
60        return dp[target.length()]==Integer.MAX_VALUE?-1:dp[target.length()];
61    }
62}