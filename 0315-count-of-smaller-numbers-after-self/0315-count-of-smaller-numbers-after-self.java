class Solution {

    public List<Integer> countSmaller(int[] nums) {

        // Coordinate compression
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : set) {
            map.put(num, rank++);
        }

        FenwickTree tree = new FenwickTree(set.size());

        LinkedList<Integer> ans = new LinkedList<>();

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {

            int r = map.get(nums[i]);

            // Count elements smaller than nums[i]
            ans.addFirst(tree.query(r - 1));

            // Add current element
            tree.update(r);
        }

        return ans;
    }
}

class FenwickTree {

    int[] tree;

    FenwickTree(int n) {
        tree = new int[n + 1];
    }

    void update(int index) {

        while (index < tree.length) {
            tree[index]++;
            index += index & -index;
        }
    }

    int query(int index) {

        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }
}