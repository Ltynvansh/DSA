class Solution {
    // These need to be outside the method to persist across recursive calls
    Integer prev = null;
    int minDistance = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDistance;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        // 1. Go Left
        inorder(root.left);

        // 2. Process Current Node
        if (prev != null) {
            // In a BST, in-order gives values in increasing order, 
            // so current.val - prev.val is always positive.
            minDistance = Math.min(minDistance, root.val - prev);
        }
        prev = root.val;

        // 3. Go Right
        inorder(root.right);
    }
}