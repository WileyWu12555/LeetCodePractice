package code.lint.three.binaryTreeDivideConquer;

/**
 * Created by 505007855 on 9/21/2017.
 */

/*
*
* Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node
down to the farthest leaf node.

Have you met this question in a real interview? Yes
Example
Given a binary tree as follow:

  1
 / \
2   3
   / \
  4   5
The maximum depth is 3.
*
* */

public class MaximumDepthOfBinaryTree {


        /**
         * @param root: The root of binary tree.
         * @return: An integer.
         */
        public int maxDepth(TreeNode root) {
            // write your code here

            if(root == null){
                return 0;
            }

            int leftPath = 1 + maxDepth(root.left);
            int rightPath = 1 + maxDepth(root.right);

            if(leftPath < rightPath){
                return leftPath;
            }else{
                return rightPath;
            }

        }


    //Jiu Zhang's Answer

    // version 1: Divide & Conquer

  /*
    public class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    */

// version 2: Traverse

   /* public class Solution {

        // @param root: The root of binary tree.
        // @return: An integer.

        private int depth;

        public int maxDepth(TreeNode root) {
            depth = 0;
            helper(root, 1);

            return depth;
        }

        private void helper(TreeNode node, int curtDepth) {
            if (node == null) {
                return;
            }

            if (curtDepth > depth) {
                depth = curtDepth;
            }

            helper(node.left, curtDepth + 1);
            helper(node.right, curtDepth + 1);
        }
    }*/


    // Shuo Chang's Answer

  /*  public class Solution {

        //@param root: The root of binary tree.
        //@return: An integer.

        public int maxDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.max(left, right) + 1;
        }
    }

    */

}
