class Solution {

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);

        int currDia = height(root.left) + height(root.right);

        return Math.max(currDia, Math.max(leftDia, rightDia));
    }
}