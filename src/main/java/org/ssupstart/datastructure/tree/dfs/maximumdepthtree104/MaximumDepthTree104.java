package org.ssupstart.datastructure.tree.dfs.maximumdepthtree104;


import org.ssupstart.datastructure.tree.TreeNode;

public class MaximumDepthTree104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int result = maxDepth(root);
        System.out.println(result);
    }


    /*
      3
     / \
    9  20
       / \
      15  7
*/
    public static int maxDepth(TreeNode root) {
        if(null == root)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }
}
