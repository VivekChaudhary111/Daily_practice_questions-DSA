// Last updated: 2/26/2026, 3:52:26 AM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Arrays.sort(arr);
4       List<Integer> list=new ArrayList<>();
5        for(int val:arr)list.add(val);
6        list.sort((a,b)->Integer.bitCount(a)-Integer.bitCount(b));
7//        return list.stream().toArray();
8        for(int i=0;i<arr.length;i++)arr[i]=list.get(i);
9        return arr;
10    }
11}