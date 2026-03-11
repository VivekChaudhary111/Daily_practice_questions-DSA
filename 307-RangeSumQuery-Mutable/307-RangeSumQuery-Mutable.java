// Last updated: 3/11/2026, 3:20:32 PM
1class NumArray {
2    int n;
3    int[] tree;
4    public NumArray(int[] nums) {
5        n = nums.length;
6        tree = new int[4 * n];
7        build(nums, 1, 0, n - 1);
8    }
9    public void build(int[] nums, int node, int start, int end){
10        if(start == end){
11            tree[node] = nums[start];
12            return;
13        }
14        int mid = (start + end)/2;
15        build(nums, 2*node, start, mid);
16        build(nums, 2*node + 1, mid + 1, end);
17        tree[node] = tree[2*node] + tree[2*node + 1];
18    }
19    
20    public void update(int index, int val) {
21        update(1, 0, n-1, index, val);
22    }
23    public void update(int node, int start, int end, int index, int val) {
24        if(start == end){
25            tree[node] = val;
26            return;
27        }
28        int mid = (start + end)/2;
29        if(index <= mid){
30            update(2*node, start, mid, index, val);
31        }
32        else{
33            update(2*node + 1, mid +1, end, index, val);
34        }
35        tree[node] = tree[2*node] + tree[2*node + 1];
36    }
37
38    
39    public int sumRange(int left, int right) {
40        return sumRange(1, left, right, 0, n -1);
41    }
42    public int sumRange(int node, int left, int right, int start, int end) {
43        if(start >= left && end <= right){
44            return tree[node];
45        }
46        if(end < left || start > right){
47            return 0;
48        }
49        int mid = (start + end) / 2;
50        int lc = sumRange(2*node, left, right, start, mid);
51        int rc = sumRange(2*node+1, left, right, mid + 1, end);
52        return lc + rc;
53    }
54
55}
56
57/**
58 * Your NumArray object will be instantiated and called as such:
59 * NumArray obj = new NumArray(nums);
60 * obj.update(index,val);
61 * int param_2 = obj.sumRange(left,right);
62 */