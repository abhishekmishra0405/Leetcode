class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode a = head.next;
        ListNode newHead = reverseList(a);

        a.next = head;
        head.next = null;

        return newHead;
    }

    public int pairSum(ListNode head) {

        // Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode secondHalf = reverseList(slow);

        // Calculate maximum twin sum
        int maxSum = 0;
        ListNode firstHalf = head;

        while (secondHalf != null) {
            int sum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, sum);

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }
}