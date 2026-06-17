class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length - 1,
                         0, inorder.length - 1);
    }

    public TreeNode construct(int[] preorder, int[] inorder,
                               int preStart, int preEnd,
                               int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = inStart;
        while (inorder[rootIndex] != root.val) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.left = construct(preorder, inorder,
                              preStart + 1,
                              preStart + leftSize,
                              inStart,
                              rootIndex - 1);

        root.right = construct(preorder, inorder,
                               preStart + leftSize + 1,
                               preEnd,
                               rootIndex + 1,
                               inEnd);

        return root;
    }
}