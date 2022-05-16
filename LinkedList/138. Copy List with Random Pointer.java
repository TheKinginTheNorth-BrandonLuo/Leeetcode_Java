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
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);
        
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }
        
        Node cur2 = head;
        while (cur2 != null) {
            Node copy = map.get(cur2);
            copy.next = map.get(cur2.next);
            copy.random = map.get(cur2.random);
            cur2 = cur2.next;
        }
        
        return map.get(head);
    }
}
