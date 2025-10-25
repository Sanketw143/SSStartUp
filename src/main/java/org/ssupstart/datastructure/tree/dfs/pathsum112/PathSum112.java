package org.ssupstart.datastructure.tree.dfs.pathsum112;

import org.ssupstart.datastructure.tree.TreeNode;

public class PathSum112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean result = hasPathSum(root,5);
        System.out.println(result);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null ) {
            if(targetSum == root.val)
                return true;
            else
                return false;
        }
        boolean leftNode = hasPathSum(root.right, targetSum - root.val);
        boolean rightNode = hasPathSum(root.right, targetSum - root.val);
        return leftNode || rightNode;
    }
}
