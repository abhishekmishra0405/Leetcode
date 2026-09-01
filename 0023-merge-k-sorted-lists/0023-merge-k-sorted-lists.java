class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of every list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode curr = pq.poll();

            // Add it to answer
            tail.next = curr;
            tail = tail.next;

            // Add next node of same list
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }
}