package org.ssupstart.datastructure.tree.dfs.sumofleftleaves404;

import org.ssupstart.datastructure.tree.TreeNode;

public class SumOfLeftLeaves404 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        int sum = sumOfLeftLeaves(root);
        System.out.println(sum);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum =0;

        if(root.left != null && root.left.left == null && root.left.right ==null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
