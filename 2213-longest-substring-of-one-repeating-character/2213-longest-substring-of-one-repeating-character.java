class Solution {

    class Node {
        int l, r;
        int prefix, suffix, best;
        char leftChar, rightChar;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.prefix = 1;
            this.suffix = 1;
            this.best = 1;
        }
    }

    char[] s;
    Node[] tree;

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update string
            this.s[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index);

            // Root contains answer for entire string
            ans[i] = tree[1].best;
        }

        return ans;
    }

    // Build segment tree
    void build(int node, int l, int r) {

        tree[node] = new Node(l, r);

        if (l == r) {
            tree[node].leftChar = s[l];
            tree[node].rightChar = s[l];
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node);
    }

    // Update one index
    void update(int node, int l, int r, int index) {

        if (l == r) {
            tree[node].leftChar = s[index];
            tree[node].rightChar = s[index];

            tree[node].prefix = 1;
            tree[node].suffix = 1;
            tree[node].best = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        merge(node);
    }

    // Merge two children
    void merge(int node) {

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];

        cur.leftChar = left.leftChar;
        cur.rightChar = right.rightChar;

        // Start with the best answer from either side
        cur.best = Math.max(left.best, right.best);

        // Prefix
        cur.prefix = left.prefix;

        if (left.prefix == left.r - left.l + 1 &&
            left.rightChar == right.leftChar) {

            cur.prefix = left.prefix + right.prefix;
        }

        // Suffix
        cur.suffix = right.suffix;

        if (right.suffix == right.r - right.l + 1 &&
            left.rightChar == right.leftChar) {

            cur.suffix = right.suffix + left.suffix;
        }

        // Can a repeating sequence cross the middle?
        if (left.rightChar == right.leftChar) {

            cur.best = Math.max(
                cur.best,
                left.suffix + right.prefix
            );
        }
    }
}