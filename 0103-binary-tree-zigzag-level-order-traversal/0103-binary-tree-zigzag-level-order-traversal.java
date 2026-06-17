class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        solve(root, 0, res);

        return res;
    }

    public void solve(TreeNode root, int lvl, List<List<Integer>> res) {

        if (root == null) {
            return;
        }

        if (res.size() == lvl) {
            res.add(new ArrayList<>());
        }

        if (lvl % 2 == 0) {
            res.get(lvl).add(root.val);
        } else {
            res.get(lvl).add(0, root.val);
        }

        solve(root.left, lvl + 1, res);
        solve(root.right, lvl + 1, res);
    }
}