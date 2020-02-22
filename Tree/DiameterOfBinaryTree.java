/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    public int depth(TreeNode root){
      if(root == null) return 0;
      int ldepth = depth(root.left);
      int rdepth = depth(root.right);
      ans = Math.max(ans,ldepth + rdepth);
      return Math.max(ldepth,rdepth)+1;

    }

  /** Time complexity - O(n) as we go through each node once
Space complexity - O(n) size of our implicit call stack
  **/
