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
        if(head ==null){
            return null;
        }
        HashMap<Node , Node > map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node oldTemp = head.next;
        Node newTemp = newHead ;
        map.put(head, newHead);// copy the address of oldNode to New Node 
        while(oldTemp != null){
            Node copyNode =new Node(oldTemp.val);
            map.put(oldTemp,copyNode);
            newTemp.next = copyNode;
            oldTemp =oldTemp.next;
            newTemp = newTemp.next;

        }
        oldTemp =head ;
        newTemp =newHead ;
        while(oldTemp != null){
            newTemp.random = map.get(oldTemp.random);// we pointing the random pointer newTemp to oldTemp 
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;

        }
        return newHead;




        
    }
}