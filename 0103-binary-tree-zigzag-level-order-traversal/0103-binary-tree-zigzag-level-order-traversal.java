class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        zigZag(root, 0, result);

        return result;
    }

    public void zigZag(TreeNode root, int lvl, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        if (result.size() == lvl) {
            result.add(new ArrayList<>());
        }

        if (lvl % 2 == 0) {
            result.get(lvl).add(root.val);
        } else {
            result.get(lvl).add(0, root.val);
        }

        zigZag(root.left, lvl + 1, result);
        zigZag(root.right, lvl + 1, result);
    }
}