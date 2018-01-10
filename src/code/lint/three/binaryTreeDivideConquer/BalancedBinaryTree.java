package code.lint.three.binaryTreeDivideConquer;

/**
 * Created by 505007855 on 9/22/2017.
 */

/*
*
* Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the
depth of the two subtrees of every node never differ by more than 1.

Have you met this question in a real interview? Yes
Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
*
* */

public class BalancedBinaryTree {

    class ResultType{
        boolean isBalance;
        int maxDepth;

        ResultType(boolean isBalance, int maxDepth){
            this.isBalance = isBalance;
            this.maxDepth = maxDepth;
        }

    }

    public boolean isBalanced(TreeNode root) {
        // write your code here

        return help(root).isBalance;
    }

    public ResultType help(TreeNode root){

        if(root == null){
            return new ResultType(true, 0);
        }

        ResultType leftTreeNode = help(root.left);
        ResultType rightTreeNode = help(root.right);

        if(!leftTreeNode.isBalance || !rightTreeNode.isBalance){
            return new ResultType(false, -1);
        }

        if( Math.abs(leftTreeNode.maxDepth - rightTreeNode.maxDepth) - 1 > 0 ){
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(leftTreeNode.maxDepth, rightTreeNode.maxDepth) + 1);

    }

}


// JIU ZHANG'a Answer

/*
*
* // Version 1: with ResultType

 Definition of TreeNode:
 public class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }

class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class Solution {

    // @param root: The root of binary tree.
    // @return: True if this Binary tree is Balanced, or false.

    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}

// Version 2: without ResultType
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
*
* */



// Shuo Chang's Answer


/*
*
* class ResultType{
    boolean isBalanced;
    int height;
    public ResultType(boolean isBalacned, int height){
        this.isBalanced = isBalacned;
        this.height = height;
    }
}

public class Solution {

   // @param root: The root of binary tree.
  //  @return: True if this Binary tree is Balanced, or false.

public boolean isBalanced(TreeNode root) {
    return helper(root).isBalanced;
}

    public ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1){
            return new ResultType (true, Math.max(left.height, right.height) + 1);
        }

        return new ResultType(false, Math.max(left.height, right.height) + 1);
    }

}
*
* */