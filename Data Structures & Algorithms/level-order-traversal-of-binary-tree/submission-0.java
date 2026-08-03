/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLevelQueue = new LinkedList<>();
            List<Integer> itemsAtCurrentLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode nextItemInCurrentLevel = queue.poll();
                itemsAtCurrentLevel.add(nextItemInCurrentLevel.val);

                if (nextItemInCurrentLevel.left != null)
                    nextLevelQueue.add(nextItemInCurrentLevel.left);
                if (nextItemInCurrentLevel.right != null)
                    nextLevelQueue.add(nextItemInCurrentLevel.right);
            }
            result.add(itemsAtCurrentLevel);
            queue = nextLevelQueue;
        }

        return result;
    }
}
