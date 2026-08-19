class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        
        // Move fast to kth node
        for(int i = 1; i < k; i++) {
            fast = fast.next;
        }
        
        ListNode first = fast;
        
        // Move slow and fast together
        ListNode slow = head;
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Swap values
        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;
        
        return head;
    }
}