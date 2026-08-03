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
            int remainingItems = queue.size();
            List<Integer> itemsInCurrentLevel = new ArrayList<>();
            while (remainingItems != 0) {
                TreeNode nextItem = queue.poll();
                itemsInCurrentLevel.add(nextItem.val);
                if (nextItem.left != null)
                    queue.add(nextItem.left);
                if (nextItem.right != null)
                    queue.add(nextItem.right);
                
                remainingItems--;
            }
            result.add(itemsInCurrentLevel);
        }

        return result;
    }
}
