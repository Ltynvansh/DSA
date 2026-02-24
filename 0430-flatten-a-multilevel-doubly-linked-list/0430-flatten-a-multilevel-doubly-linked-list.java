class Solution {

    public Node flatten(Node head) {
        if (head == null) return null;

        flattenDFS(head);
        return head;
    }

    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childLast = flattenDFS(curr.child);

                // connect curr -> child
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                // connect child's last -> next
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                last = childLast;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}