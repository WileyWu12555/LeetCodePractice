package code.lint.three.binaryTreeDivideConquer;

import java.util.ArrayList;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

/*
* Given a binary tree, return the preorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given:

    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].

Challenge
Can you do it without recursion?

给出一棵二叉树，返回其节点值的前序遍历。
*
* */
public class BinaryTreePreorderTraversal {

    /*
   * @param root: A Tree
   * @return: Preorder in ArrayList which contains node values.
   */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here

        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;

    }

    // Jiu Zhang's Answer
    /*
    *
      // Version 0: Non-Recursion (Recommend)

          public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;
    }

    //Version 1: Traverse

     public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    // 把root为跟的preorder加入result里面
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    //Version 2: Divide & Conquer
     public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    *
    * */

    // Shuo Chang's Answer
    /*
    *
    // Method 1
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    // Method 2

     public ArrayList<Integer> preorderTraversal(TreeNode root){
         ArrayList<Integer> result = new ArrayList<Integer>();
         if (root == null){
             return result;
         }
         ArrayList<Integer> left = preorderTraversal(root.left);
         ArrayList<Integer> right = preorderTraversal(root.right);

         result.add(root.val);
         result.addAll(left);
         result.addAll(right);
         return result;
     }

    *
    * */
}
