// Last updated: 2/6/2026, 3:12:50 PM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node prev;
6    public Node next;
7    public Node child;
8};
9*/
10
11class Solution {
12    public Node flatten(Node head) {
13        solve(head);
14        return head;
15    }
16    public Node solve(Node head){
17        Node dummy = head;
18        Node tail = head;
19
20        while(dummy != null){
21            if(dummy.child != null){
22                Node nextt = dummy.next;
23                Node nn = solve(dummy.child);
24
25                dummy.next = dummy.child;
26                dummy.child.prev = dummy;
27                dummy.child = null;
28
29                // attach back next
30                if(nextt != null){
31                    nn.next = nextt;
32                    nextt.prev = nn;
33                }
34
35                tail = nn;
36                dummy = nn;   // jump to end of child
37            } else {
38                tail = dummy;
39            }
40            dummy = dummy.next; // mandatory forward move
41        }
42        return tail;
43    }
44}