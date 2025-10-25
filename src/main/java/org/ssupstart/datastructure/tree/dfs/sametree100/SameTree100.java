package org.ssupstart.datastructure.tree.dfs.sametree100;

import org.ssupstart.datastructure.tree.TreeNode;


public class SameTree100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));


        boolean result = isSameTree(p,q);
        System.out.println(result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p  && null == q)
            return true;
        if((null != p && null == q) || (null == p && null != q) || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}
