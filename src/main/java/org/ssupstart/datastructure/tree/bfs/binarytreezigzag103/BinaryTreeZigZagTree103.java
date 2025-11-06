package org.ssupstart.datastructure.tree.bfs.binarytreezigzag103;

import org.ssupstart.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagTree103 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean forward = true;

        while (!queue.isEmpty()) {
            Integer size = queue.size();
            LinkedList<Integer> arr = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(forward)
                    arr.addLast(node.val);
                else
                    arr.addFirst(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(arr);
            forward = !forward;
        }
        return result;
    }

}
