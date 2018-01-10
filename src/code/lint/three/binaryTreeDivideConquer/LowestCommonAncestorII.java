package code.lint.three.binaryTreeDivideConquer;

import java.util.ArrayList;

/*

Given the root and two nodes in a Binary Tree.
Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.

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

最近公共祖先 II
给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。

两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。

每个节点除了左右儿子指针以外，还包含一个父亲指针parent，指向自己的父亲。

*
* */
public class LowestCommonAncestorII {

    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here

        if(root == null){
            return null;
        }

        if(root == A || root == B || root == A.parent || root == B.parent){
            return root;
        }

        ArrayList<ParentTreeNode> pathA = getParentPath(A);
        ArrayList<ParentTreeNode> pathB = getParentPath(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        ParentTreeNode lowestParentNode = null;

        while(indexA >= 0 && indexB >= 0){
            if(pathA.get(indexA) != pathB.get(indexB)){
                break;
            }
            lowestParentNode = pathA.get(indexA);
            indexA--;
            indexB--;
        }

        return lowestParentNode;

    }

    public ArrayList<ParentTreeNode> getParentPath(ParentTreeNode node){
        ArrayList<ParentTreeNode> paths = new ArrayList<>();
        while(node != null){
            paths.add(node);
            node = node.parent;
        }

        return paths;
    }

    // Jiu Zhang's Answer

    /*
    *
    * public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }

        return lowestAncestor;
    }

    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    * public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        List<ParentTreeNode> aPath = getPath(A);
        List<ParentTreeNode> bPath = getPath(B);

        int indexA = aPath.size() - 1;
        int indexB = bPath.size() - 1;
        ParentTreeNode result = null;
        while (indexA >= 0 && indexB >= 0){
            if (aPath.get(indexA) != bPath.get(indexB)){
                break;
            }
            result = aPath.get(indexA);
            indexA--;
            indexB--;
        }

        return result;

    }

    public List<ParentTreeNode> getPath(ParentTreeNode node){
        List<ParentTreeNode> list = new ArrayList<ParentTreeNode>();
        while (node != null){
            list.add(node);
            node = node.parent;
        }
        return list;
    }
    *
    * */
}
