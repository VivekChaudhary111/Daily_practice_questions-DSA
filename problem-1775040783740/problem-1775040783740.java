// Last updated: 4/1/2026, 4:23:03 PM
1class Solution {
2    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
3        int n =  positions.length;
4        Pair[] p = new Pair[n];
5        for(int i = 0; i < n; i++){
6            Pair pair = new Pair(positions[i], healths[i], directions.charAt(i), i);
7            p[i] = pair;
8        }
9        Arrays.sort(p, (a, b)-> a.pos - b.pos);
10        Stack<Pair> st = new Stack<>();
11        for(int i = 0; i < n; i++){
12            if(p[i].dir == 'R'){
13                st.push(p[i]);
14            }else{
15                while(!st.isEmpty() && st.peek().dir == 'R'){
16                    Pair rp = st.peek();
17
18                    if(rp.health == p[i].health){
19                        st.pop();
20                        p[i].health = 0;
21                        break;
22                    }else if(rp.health < p[i].health){
23                        st.pop();
24                        p[i].health--;
25                    }else{
26                        rp.health--;
27                        p[i].health = 0;
28                        break;
29                    }
30                }
31
32                if(p[i].health > 0){
33                    st.push(p[i]);
34                }
35            }
36        }
37        List<Pair> ans = new ArrayList<>();
38        while(!st.isEmpty()){
39            ans.add(st.pop());
40        }
41        Collections.sort(ans, (a, b) -> a.idx - b.idx);
42        List<Integer> ansFinal = new ArrayList<>();
43        for(int i = 0; i < ans.size(); i++){
44            ansFinal.add(ans.get(i).health);
45        }
46        return ansFinal;
47    }
48    class Pair{
49        int pos;
50        int health;
51        char dir;
52        int idx;
53        public Pair(int pos, int health, char dir, int idx){
54            this.pos = pos;
55            this.health =health;
56            this.dir = dir;
57            this.idx = idx;
58        }
59    }
60}