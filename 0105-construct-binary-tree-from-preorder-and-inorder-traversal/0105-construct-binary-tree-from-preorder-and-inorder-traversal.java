class Solution {

    int preIdx = 0;

    public int search(int[] inorder, int left, int right, int val){
        for(int i = left; i <= right; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;

        int inIdx = search(inorder, left, right, root.val);

        root.left = helper(preorder, inorder, left, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}