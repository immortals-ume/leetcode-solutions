/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Copy the value from the next node into the current node
        node.val = node.next.val;
        // Change the next pointer to skip the node being removed
        node.next = node.next.next;
    }
}