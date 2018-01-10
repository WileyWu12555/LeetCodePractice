package code.lint.three.binaryTreeDivideConquer;

/*
*
* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest
path from the root node down to the nearest leaf node.

Have you met this question in a real interview? Yes
Example
Given a binary tree as follow:

  1
 / \
2   3
   / \
  4   5
The minimum depth is 2.

二叉树的最小深度

给定一个二叉树，找出其最小深度。

二叉树的最小深度为根节点到最近叶子节点的距离。


*
* */
public class MinimumDepthOfBinaryTree {
    /*
     * @param root: The root of binary tree
     * @return: An integer
     */

    public int minDepth(TreeNode root) {
        // write your code here

        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int left = minDepth(root.left);

        int right = minDepth(root.right);

        if(root.left != null && root.right == null){

            return left + 1;

        }else if(root.right != null && root.left == null){

            return right + 1;

        }

        return Math.min(left, right) + 1;
    }


    // Jiu Zhang's Answer

    /*
    * public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    * public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null && root.right != null){
            return  right + 1;
        } else if (root.left != null && root.right == null){
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }
    * */
}
