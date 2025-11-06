package org.ssupstart.datastructure.tree.bfs.maxlevelsum1161;

import org.ssupstart.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSum1161 {

    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int maxLevel  = 1;
        int level =1;
        int sum = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for(int i=0;i<size ; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right !=null)
                    queue.add(node.right);
            }
            if(levelSum > sum) {
                sum = levelSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}
