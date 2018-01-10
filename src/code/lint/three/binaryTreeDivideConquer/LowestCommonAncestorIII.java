package code.lint.three.binaryTreeDivideConquer;


/*
*
* Given the root and two nodes in a Binary Tree.
* Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

 Notice

node A or node B may not exist in tree.

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

给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。

两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。

返回 null 如果两个节点在这棵树上不存在最近公共祖先的话。

*
* */

class ResultType {
    boolean a_exist;
    boolean b_exist;
    TreeNode node;
    public ResultType(boolean a_exist, boolean b_exist, TreeNode node){
        this.a_exist = a_exist;
        this.b_exist = b_exist;
        this.node = node;
    }
}

public class LowestCommonAncestorIII {

    /*
   * @param root: The root of the binary tree.
   * @param A: A TreeNode
   * @param B: A TreeNode
   * @return: Return the LCA of the two nodes.
   */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

        ResultType result = helper(root, A, B);
        if(result.a_exist && result.b_exist){
            return result.node;
        }else {
            return null;
        }
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B){


        if(root == null){
            return new ResultType(false, false, null);
        }

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean a_exist = left.a_exist || right.a_exist || A == root;
        boolean b_exist = left.b_exist || right.b_exist || B == root;

        if(A == root || B == root){
            return new ResultType(a_exist, b_exist, root);
        }

        if(left.node != null && right.node != null){
            return new ResultType(a_exist, b_exist, root);
        }

        if(left.node != null){
            return new ResultType(a_exist, b_exist, left.node);
        }

        if(right.node != null){
            return new ResultType(a_exist, b_exist, right.node);
        }

        return new ResultType(a_exist, b_exist, null);

    }

    // Jiu Zhang's Answer

    /*

    class ResultType {
    public boolean a_exist, b_exist;
    public TreeNode node;
    ResultType(boolean a, boolean b, TreeNode n) {
        a_exist = a;
        b_exist = b;
        node = n;
    }
}

public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType rt = helper(root, A, B);
        if (rt.a_exist && rt.b_exist)
            return rt.node;
        else
            return null;
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return new ResultType(false, false, null);

        ResultType left_rt = helper(root.left, A, B);
        ResultType right_rt = helper(root.right, A, B);

        boolean a_exist = left_rt.a_exist || right_rt.a_exist || root == A;
        boolean b_exist = left_rt.b_exist || right_rt.b_exist || root == B;

        if (root == A || root == B)
            return new ResultType(a_exist, b_exist, root);

        if (left_rt.node != null && right_rt.node != null)
            return new ResultType(a_exist, b_exist, root);
        if (left_rt.node != null)
            return new ResultType(a_exist, b_exist, left_rt.node);
        if (right_rt.node != null)
            return new ResultType(a_exist, b_exist, right_rt.node);

        return new ResultType(a_exist, b_exist, null);
    }

    * */


    // Shuo Chang's Answer
    /*

    class ResultType {
    boolean a_exists;
    boolean b_exists;
    TreeNode root;
    public ResultType(boolean a_exists, boolean b_exists, TreeNode root){
        this.a_exists = a_exists;
        this.b_exists = b_exists;
        this.root = root;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = helper(root, A, B);
        if (result.a_exists && result.b_exists){
            return result.root;
        }
        return null;
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new ResultType(false, false,null);
        }
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        boolean a_exists = left.a_exists || right.a_exists || root == A;
        boolean b_exists = left.b_exists || right.b_exists || root == B;
        if (root == A || root == B){
            return new ResultType(a_exists, b_exists, root);
        } else if(left.root != null && right.root != null){
            return new ResultType(a_exists, b_exists, root);
        } else if (left.root != null){
            return new ResultType(a_exists, b_exists, left.root);
        } else if (right.root != null){
            return new ResultType(a_exists, b_exists, right.root);
        }
        return new ResultType(a_exists, b_exists, null);

    }

    * */

}
