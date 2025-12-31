// Last updated: 12/31/2025, 3:53:17 PM
1class Solution {
2
3    int[] parent;
4
5    // Find with path compression
6    private int findParent(int x) {
7        if (parent[x] == x) return x;
8        return parent[x] = findParent(parent[x]);
9    }
10
11    public List<List<String>> accountsMerge(List<List<String>> accounts) {
12
13        int n = accounts.size();
14        parent = new int[n];
15
16        // Initialize parent array
17        for (int i = 0; i < n; i++) {
18            parent[i] = i;
19        }
20
21        // Map each email to an account index
22        Map<String, Integer> emailToIndex = new HashMap<>();
23
24        for (int i = 0; i < n; i++) {
25            List<String> acc = accounts.get(i);
26            for (int j = 1; j < acc.size(); j++) {
27                String email = acc.get(j);
28
29                if (!emailToIndex.containsKey(email)) {
30                    emailToIndex.put(email, i);
31                } else {
32                    int prevIndex = emailToIndex.get(email);
33                    int p1 = findParent(i);
34                    int p2 = findParent(prevIndex);
35
36                    if (p1 != p2) {
37                        parent[p2] = p1;   // Union
38                    }
39                }
40            }
41        }
42
43        // Group emails by root parent
44        Map<Integer, TreeSet<String>> rootToEmails = new HashMap<>();
45
46        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
47            String email = entry.getKey();
48            int idx = entry.getValue();
49            int root = findParent(idx);
50
51            rootToEmails
52                .computeIfAbsent(root, k -> new TreeSet<>())
53                .add(email);
54        }
55
56        // Build result
57        List<List<String>> result = new ArrayList<>();
58
59        for (Map.Entry<Integer, TreeSet<String>> entry : rootToEmails.entrySet()) {
60            int idx = entry.getKey();
61            List<String> merged = new ArrayList<>();
62
63            // Account name
64            merged.add(accounts.get(idx).get(0));
65
66            // Sorted emails
67            merged.addAll(entry.getValue());
68
69            result.add(merged);
70        }
71
72        return result;
73    }
74}
75