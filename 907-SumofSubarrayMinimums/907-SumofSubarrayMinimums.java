// Last updated: 1/19/2026, 12:20:34 PM
1class Solution {
2    public int sumSubarrayMins(int[] arr) {
3	    Deque<Integer> stack = new ArrayDeque<>();
4        
5        // left bound we set of -1
6        stack.push(-1);
7        long res = 0;
8        for(int i = 0; i < arr.length; i++) {
9            while(stack.size() > 1 && arr[stack.peek()] > arr[i]) {
10                int currElemIndex = stack.pop();
11                res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * ( i - currElemIndex)) % 1000000007;
12                res = res % 1000000007;
13            }
14            stack.push(i);
15        }
16    
17        int rightBoundary = arr.length;
18    
19        while(stack.size() > 1) {
20            int currElemIndex = stack.pop();
21            res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * (rightBoundary - currElemIndex)) % 1000000007;
22            res = res % 1000000007;
23        }
24        
25        return (int) res;
26        
27    }
28}