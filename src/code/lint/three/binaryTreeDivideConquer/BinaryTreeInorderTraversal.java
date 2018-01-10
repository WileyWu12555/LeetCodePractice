package code.lint.three.binaryTreeDivideConquer;

import java.util.ArrayList;

/**
 * Created by 505007855 on 9/25/2017.
 */

    /*
    *
    * Given a binary tree, return the inorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3


return [1,3,2].

Can you do it without recursion?

给出一棵二叉树,返回其中序遍历.
    *
    * */
public class BinaryTreeInorderTraversal {

    /*
    * @param root: A Tree
    * @return: Inorder in ArrayList which contains node values.
    */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return null;
        }

        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    /*
    * @param root: A Tree
    * @return: Inorder in ArrayList which contains node values.
    */
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    public void helper(ArrayList<Integer> result, TreeNode root){

        if(root == null){
            return;
        }

        helper(result, root.left);
        result.add(root.val);
        helper(result, root.right);

    }


    // JIU ZHANG's Answer
    /*
    *
    * public class Solution {
     // @param root: The root of binary tree.
     // @return: Inorder in ArrayList which contains node values.

        public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}
    *
    * */



    // Shuo Chang's Answer
    /*
    *
    * public class Solution {

    //  @param root: The root of binary tree.
    // @return: Inorder in ArrayList which contains node values.

    //Divide conquer
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     if(root == null){
    //         return result;
    //     }
    //     ArrayList<Integer> leftResult = inorderTraversal(root.left);
    //     ArrayList<Integer> rightResult = inorderTraversal(root.right);
    //     result.addAll(leftResult);
    //     result.add(root.val);
    //     result.addAll(rightResult);


    //     return result;
    // }

    //Traversal
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(result, root);
        return result;
    }

    public void helper(ArrayList<Integer> result, TreeNode root){
        if(root == null){
            return;
        }

        helper(result, root.left);

        result.add(root.val);

        helper(result, root.right);

    }

}
    *
    * */


}
