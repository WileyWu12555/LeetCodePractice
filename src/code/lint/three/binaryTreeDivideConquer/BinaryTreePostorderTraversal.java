package code.lint.three.binaryTreeDivideConquer;

import java.util.ArrayList;

/*
* Given a binary tree, return the postorder traversal of its nodes' values.

Have you met this question in a real interview? Yes
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3


return [3,2,1].

Challenge
Can you do it without recursion?

给出一棵二叉树，返回其节点值的后序遍历。
*
* */
public class BinaryTreePostorderTraversal {

    /*
    * @param root: A Tree
    * @return: Postorder in ArrayList which contains node values.
    */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here

        ArrayList<Integer> result = new ArrayList();

        if(root == null){
            return result;
        }

       result.addAll(postorderTraversal(root.left));
       result.addAll(postorderTraversal(root.right));
       result.add(root.val);

       return result;
    }




    // Jiu Zhang's Answer
    /*
    *
   //Recursive
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    if (root == null) {
        return result;
    }

    result.addAll(postorderTraversal(root.left));
    result.addAll(postorderTraversal(root.right));
    result.add(root.val);

    return result;
}

    //Iterative
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;

    if (root == null) {
        return result;
    }

    stack.push(root);
    while (!stack.empty()) {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
            if (curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.left == prev) { // traverse up the tree from the left
            if (curr.right != null) {
                stack.push(curr.right);
            }
        } else { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }

    return result;
}
    *
    * */

    // Shuo Chang's Answer

    //1.recursive traversal
    /*    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traversalHelper(root, result);
        return result;
    }

    public void traversalHelper(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return ;
        }
        traversalHelper(root.left, result);
        traversalHelper(root.right, result);
        result.add(root.val);
    }*/

    //2. divide conquer
   /*
    public ArrayList<Integer> postorderTraversal(TreeNode root)

      ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        ArrayList<Integer> leftResult = postorderTraversal(root.left);
        ArrayList<Integer> rightResult = postorderTraversal(root.right);

        result.addAll(leftResult);
        result.addAll(rightResult);
        result.add(root.val);

        return result;
    }

    */
}
