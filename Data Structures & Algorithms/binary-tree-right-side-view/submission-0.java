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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            for (int count = nodes.size(); count > 0; count--) {
                TreeNode next = nodes.poll();
                if (next.left != null) {
                    nodes.offer(next.left);
                }
                if (next.right != null) {
                    nodes.offer(next.right);
                }
                if (count == 1) {
                    // Last node at the current level
                    result.add(next.val);
                }
            }
        }
        return result;
    }
}
