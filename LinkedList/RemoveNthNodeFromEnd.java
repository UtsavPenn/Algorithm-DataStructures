/**Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode prev = new ListNode(-1);
        ListNode fastrunner = current;
        int i = 0;

        while(fastrunner!=null && i<n){
            fastrunner = fastrunner.next;
            i++;
        }

        if(fastrunner == null){
            head = head.next;
        }
        while (fastrunner!=null){
            prev = current;
            current = current.next;
            fastrunner = fastrunner.next;
        }

        if(current!=null){
            prev.next = current.next;
            current = prev;
        }
        return head;
    }
}
