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
    TreeNode prev;
    int minDiff;
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        absDiff(root);
        return minDiff;    
    }

    public void absDiff(TreeNode node){
        if(node == null) return;

        absDiff(node.left);

        if(prev != null){
            minDiff = Math.min(minDiff , Math.abs(prev.val - node.val));
        } 
        prev = node;

        absDiff(node.right);
    }
}