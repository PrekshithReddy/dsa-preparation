class Solution {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int value = preorder[preIndex++];
        TreeNode root = new TreeNode(value);

        int pos = start;
        while (inorder[pos] != value) {
            pos++;
        }

        root.left = build(preorder, inorder, start, pos - 1);
        root.right = build(preorder, inorder, pos + 1, end);

        return root;
    }
}