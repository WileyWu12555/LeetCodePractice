package code.lint.three.binaryTreeDivideConquer;

/**
 * Created by 505007855 on 9/18/2017.
 */

/*

Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5
return the node 1.

*
* */

public class MinimumSubtree {

    private TreeNode subTree = null;
    private int subTreeSum = Integer.MAX_VALUE;

    //@param root: the root of binary tree
     //@return: the root of the minimum subtree

    public TreeNode findSubtree(TreeNode root) {
        // write your code here

        helper(root);
        return subTree;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int sum = helper(root.left) + helper(root.right) + root.val;
        if(sum <= subTreeSum ){
            subTreeSum = sum;
            subTree = root;
        }

        return sum;
    }



    // JIU Zhang's Answer

    // version 1 : traverse + divide conquer
   /* public class Solution {
        private TreeNode subtree = null;
        private int subtreeSum = Integer.MAX_VALUE;

        @param root the root of binary tree
        @return the root of the minimum subtree

        public TreeNode findSubtree(TreeNode root) {
            helper(root);
            return subtree;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int sum = helper(root.left) + helper(root.right) + root.val;
            if (sum <= subtreeSum) {
                subtreeSum = sum;
                subtree = root;
            }
            return sum;
        }
    }

     version 2: Pure divide conquer
    class ResultType {
        public TreeNode minSubtree;
        public int sum, minSum;
        public ResultType(TreeNode minSubtree, int minSum, int sum) {
            this.minSubtree = minSubtree;
            this.minSum = minSum;
            this.sum = sum;
        }
    }

    public class Solution {

         @param root the root of binary tree
         @return the root of the minimum subtree

        public TreeNode findSubtree(TreeNode root) {
            ResultType result = helper(root);
            return result.minSubtree;
        }

        public ResultType helper(TreeNode node) {
            if (node == null) {
                return new ResultType(null, Integer.MAX_VALUE, 0);
            }

            ResultType leftResult = helper(node.left);
            ResultType rightResult = helper(node.right);

            ResultType result = new ResultType(
                    node,
                    leftResult.sum + rightResult.sum + node.val,
                    leftResult.sum + rightResult.sum + node.val
            );

            if (leftResult.minSum <= result.minSum) {
                result.minSum = leftResult.minSum;
                result.minSubtree = leftResult.minSubtree;
            }

            if (rightResult.minSum <= result.minSum) {
                result.minSum = rightResult.minSum;
                result.minSubtree = rightResult.minSubtree;
            }

            return result;
        }
    }

   */


    // Shuo Chang's Answer

   /* TreeNode minTree;
    int minValue = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return minTree;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int curt = left + right + root.val;

        if (minTree == null || minValue > curt){
            minTree = root;
            minValue = curt;
        }

        return curt;
    }

    */


}
