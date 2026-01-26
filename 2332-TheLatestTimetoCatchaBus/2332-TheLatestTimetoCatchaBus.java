// Last updated: 1/26/2026, 11:59:44 PM
1class Solution {
2    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
3        Arrays.sort(buses);
4        Arrays.sort(passengers);
5        Set<Integer> set = new HashSet<>();
6        int p = 0;
7        int maxMin = 0;
8        for(int b=0;b<buses.length;b++){
9            int cap = 0;
10            while(p < passengers.length && cap < capacity && passengers[p] <= buses[b]){
11                cap++;
12                if(!set.contains(passengers[p]-1))
13                    maxMin = passengers[p]-1;
14                set.add(passengers[p]);
15                p++;
16            }
17
18            if(cap < capacity && !set.contains(buses[b]))
19                maxMin = buses[b];
20        }
21        return maxMin;
22    }
23}