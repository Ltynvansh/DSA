

import java.util.*;

class Solution {

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        int maxWidth = 0;

        while(!q.isEmpty()){

            int size = q.size();
            int start = q.peek().getValue();
            int end = start;

            for(int i = 0; i < size; i++){

                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue();

                end = index;

                if(node.left != null){
                    q.add(new Pair<>(node.left, index * 2 + 1));
                }

                if(node.right != null){
                    q.add(new Pair<>(node.right, index * 2 + 2));
                }
            }

            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}