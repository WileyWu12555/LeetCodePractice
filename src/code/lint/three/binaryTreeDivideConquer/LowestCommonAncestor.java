package code.lint.three.binaryTreeDivideConquer;

/*
*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

 Notice

Assume two nodes are exist in tree.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。

最近公共祖先是两个节点的公共的祖先节点且具有最大深度。

*
* */

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

public class LowestCommonAncestor {

    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode result = helper(root, A, B);

        return result;
    }

    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){

        if(root == null){
            return null;
        }

        if(root == A || root == B){
            return root;
        }

        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        }

        if(right != null){
            return right;
        }

        return null;
    }


    // Jiu Zhang's Answer

    /*

    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);

        // Conquer
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    * */

// Shuo Chang's Answer
    /*
    *
    *  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        return helper(root, A, B);
    }

    public TreeNode helper (TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return null;
        }
        if (root == A || root == B){
            return root;
        }

        TreeNode left = helper (root.left, A , B );
        TreeNode right = helper (root.right, A, B);

        if (left != null && right != null){
            return root;
        }

        if (left != null){
            return left;
        }

        if (right != null){
            return right;
        }

        return null;
    }
    *
    * */

}
