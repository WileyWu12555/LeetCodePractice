package code.lint.three.binaryTreeDivideConquer;

/*

Given a binary search tree (See Definition) and a node in it,
find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

 Notice

It's guaranteed p is one node in the given tree.
(You can directly compare the memory address to find p)

Have you met this question in a real interview? Yes
Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

Challenge
O(h), where h is the height of the BST.

*
* 给一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点的中序遍历后继，如果没有返回null
* */

public class InorderSuccessorInBinarySearchTree {

    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here

        if(root == null || p == null){
            return null;
        }

        TreeNode successor = null;

        while(root != null){
            if(root.val <= p.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }

        return successor;

    }

    // Jiu Zhang's Answer

    /*

// Method.1

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root != p) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return successor;
        }

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // version: 高频题班

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    * */


    // Shuo Chang's Answer

    /*
    *
    * public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null){
            return null;
        }
        TreeNode successor = null;
        while (root != null){
            if (root.val <= p.val){
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    *
    * */

}
