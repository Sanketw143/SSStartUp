package org.ssupstart.datastructure.tree.dfs.symmetrictree101;

import org.ssupstart.datastructure.tree.TreeNode;

public class SymmetricTree101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }

/*              1
              /   \
             2     2
            / \   / \
           3   4 4   3  */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }
}
