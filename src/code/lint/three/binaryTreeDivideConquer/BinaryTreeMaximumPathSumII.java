package code.lint.three.binaryTreeDivideConquer;


/*
*
* Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree and contain at least one node in it.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)


*
* */

public class BinaryTreeMaximumPathSumII {

    /*
    * @param root: the root of binary tree.
    * @return: An integer
    */
    public int maxPathSum2(TreeNode root) {
        // write your code here


        if(root == null){
            return Integer.MIN_VALUE;
        }

        int leftSum = maxPathSum2(root.left);
        int rightSum = maxPathSum2(root.right);

     /*   leftSum += Math.max(root.val, 0);
        rightSum += Math.max(root.val, 0);

        if(leftSum < rightSum){
            return rightSum;
        }else {
            return leftSum;
        }*/

        return root.val + Math.max(Math.max(leftSum, rightSum), 0);

    }

    // Jiu Zhang's Answer

    /*
    * public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * public int maxPathSum2(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        if (Math.max(left, right) < 0){
            return root.val;
        }
        return Math.max(left, right) + root.val;
    }
    *
    * */

}
