// Last updated: 3/29/2026, 8:44:36 AM
1class EventManager {
2    PriorityQueue<int[]> pq;
3    HashMap<Integer, Integer> map;
4    public EventManager(int[][] events) {
5        pq = new PriorityQueue<>((a,b)-> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
6        map = new HashMap<>();
7        for(int[] event: events){
8            pq.add(event);
9            map.put(event[0], event[1]);
10        }
11    }
12    
13    public void updatePriority(int eventId, int newPriority) {
14        map.put(eventId, newPriority);
15        pq.add(new int[] {eventId, newPriority});
16    }
17    
18    public int pollHighest() {
19        while(!pq.isEmpty()) {
20            int[] ele = pq.poll();
21            if(map.containsKey(ele[0]) && map.get(ele[0]) == ele[1]){
22                map.remove(ele[0]);
23                return ele[0];
24            }
25            
26        }
27        return -1;
28    }
29}
30
31/**
32 * Your EventManager object will be instantiated and called as such:
33 * EventManager obj = new EventManager(events);
34 * obj.updatePriority(eventId,newPriority);
35 * int param_2 = obj.pollHighest();
36 */