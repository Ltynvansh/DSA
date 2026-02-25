/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp =head ;
        int count =0;
        while(count<k){
            //if k node does not exist we need to return original head 
            if(temp == null){
                return head ;
            
            }
            temp =temp.next ;
            count ++;
        }
        ListNode prevNode = reverseKGroup(temp,k);
        // Now we again reinitailize temp --> head
        temp = head;
        count =0;
        while(count <k ){
            ListNode next = temp.next ;
            temp.next = prevNode ;
            prevNode = temp;
            temp = next ;
            count ++;

        }
        return prevNode ;

    }
}