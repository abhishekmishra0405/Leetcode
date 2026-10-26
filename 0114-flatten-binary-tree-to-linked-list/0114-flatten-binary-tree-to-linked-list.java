class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode r = curr.right;

                curr.right = curr.left;

                TreeNode pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                pred.right = r;
                curr.left = null; // IMPORTANT

                curr = curr.right;
            } else {
                curr = curr.right;
            }
        }
    }
}