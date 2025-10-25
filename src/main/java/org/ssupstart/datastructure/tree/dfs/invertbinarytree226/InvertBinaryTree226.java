package org.ssupstart.datastructure.tree.dfs.invertbinarytree226;

import org.ssupstart.datastructure.tree.TreeNode;

public class InvertBinaryTree226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        TreeNode resultRoot = invertTree(root);
        System. out.println(resultRoot.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
