package org.ssupstart.datastructure.queueandheapREVISIONPENDING.queue.binarytreeleveltraversel102;



//Given the root of a binary tree, return the level order traversal of
//its nodes' values. (i.e., from left to right, level by level).


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelTraversal102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(null == root)
            return result;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);

                if(null != currentNode.left) {
                    queue.offer(currentNode.left);
                }
                if (null != currentNode.right) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelNodes);
        }

        return result;
    }
}
