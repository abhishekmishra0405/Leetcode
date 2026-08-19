class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        // move fast n steps ahead
        for(int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            // delete head
            return head.next;
        }

        // move slow and fast together
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // delete the nth node from end
        slow.next = slow.next.next;

        return head;
    }
}