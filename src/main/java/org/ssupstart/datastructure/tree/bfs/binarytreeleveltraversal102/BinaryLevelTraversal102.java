package org.ssupstart.datastructure.tree.bfs.binarytreeleveltraversal102;

import org.ssupstart.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelTraversal102 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer size = queue.size();
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arr.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(arr);
        }
        return result;
    }
}
