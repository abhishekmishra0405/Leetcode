class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int min, int max) {
        if (i == preorder.length) {
            return null;
        }

        int val = preorder[i];

        if (val < min || val > max) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        i++;

        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }
}
