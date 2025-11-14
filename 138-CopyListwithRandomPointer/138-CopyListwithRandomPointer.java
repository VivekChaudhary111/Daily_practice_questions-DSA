// Last updated: 11/14/2025, 12:02:11 PM
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copyhead = head; 
        HashMap<Node, Node> map = new HashMap<>();
        Node deepCopy;
        if(head != null){
            deepCopy = new Node(head.val);
        }else{
            return null;
        }
        map.put(head, deepCopy);
        while(head.next != null){
            Node nn = new Node(head.next.val);
            map.put(head.next, nn);
            head = head.next;
        }
        while(copyhead != null){
            Node nn = map.get(copyhead);
            nn.next = map.get(copyhead.next);
            nn.random = map.get(copyhead.random);
            copyhead = copyhead.next;

        }
        return deepCopy;
    }
}