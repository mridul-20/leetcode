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
    public static int count;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        count =0;
        recu(root);
        return count;
    }

    public void recu(TreeNode node){
        if(node == null) return ;

        count++;
        recu(node.left);
        recu(node.right);
    }
}