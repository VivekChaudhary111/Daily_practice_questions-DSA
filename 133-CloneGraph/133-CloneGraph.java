// Last updated: 1/3/2026, 12:16:35 AM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22    public Node cloneGraph(Node node) {
23        if (node == null) {
24            return null;
25        }
26
27        Node[] freq = new Node[101];
28        Queue<Node> q = new LinkedList<>();
29
30        freq[node.val] = new Node(node.val);
31        q.offer(node);
32
33        while (!q.isEmpty()) {
34            Node cur = q.poll();
35
36            Node curClone = freq[cur.val];
37
38            for (Node nei : cur.neighbors) {
39                if (freq[nei.val] == null) {
40                    freq[nei.val] = new Node(nei.val);
41                    q.offer(nei);
42                }
43
44                curClone.neighbors.add(freq[nei.val]);
45            }
46        }
47
48        return freq[node.val];
49    }
50}
51