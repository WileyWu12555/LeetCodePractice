package code.lint.four.breadthFirstSearch;

/*

Clone an undirected graph. Each node in the graph contains
a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and ,
as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains
three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself),
thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
Have you met this question in a real interview? Yes
Example
return a deep copied graph.

克隆图
克隆一张无向图，图中的每个节点包含一个 label 和一个列表 neighbors。

数据中如何表示一个无向图？

你的程序需要返回一个经过深度拷贝的新图。
这个新图和原图具有同样的结构，并且对新图的任何改动不会对原图造成任何影响。

* */

public class CloneGraph {

    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here



    }

    // Jiu Zhang's Answer
    /*
    *
    // Version 1

    //
    // 用3个步骤：

    // 从1个点找到所有点
    // 复制所有的点
    // 复制所有的边

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }

    // Version 2
    // 用非递归版本的DFS来遍历所有的点。

    class StackElement {
    public UndirectedGraphNode node;
    public int neighborIndex;
    public StackElement(UndirectedGraphNode node, int neighborIndex) {
        this.node = node;
        this.neighborIndex = neighborIndex;
    }
}

public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use dfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Stack<StackElement> stack = new Stack<StackElement>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        stack.push(new StackElement(node, -1));
        set.add(node);

        while (!stack.isEmpty()) {
            StackElement current = stack.peek();
            current.neighborIndex++;
            // there is no more neighbor to traverse for the current node
            if (current.neighborIndex == current.node.neighbors.size()) {
                stack.pop();
                continue;
            }

            UndirectedGraphNode neighbor = current.node.neighbors.get(
                current.neighborIndex
            );
            // check if we visited this neighbor before
            if (set.contains(neighbor)) {
                continue;
            }

            stack.push(new StackElement(neighbor, -1));
            set.add(neighbor);
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }

    // Version 3

//    两个步骤：
//
//    一边找到所有的点，一边复制所有的点。
//    复制所有的边

 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }


    *
    * */

    // Shuo Chang's Answer
    /*

     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Set<UndirectedGraphNode> nodes = findNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> copiedNodes = cloneNodes(nodes);
        for (UndirectedGraphNode ele : nodes){
            UndirectedGraphNode newNode = copiedNodes.get(ele);
            for (UndirectedGraphNode neighbor : ele.neighbors){
                newNode.neighbors.add(copiedNodes.get(neighbor));
            }
        }
        return copiedNodes.get(node);
    }

    public Set<UndirectedGraphNode> findNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> result = new HashSet<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            result.add(head);
            for (UndirectedGraphNode neighbor : head.neighbors){
                if (result.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
            }
        }
        return result;
    }

    public Map<UndirectedGraphNode, UndirectedGraphNode> cloneNodes (Set<UndirectedGraphNode> nodes){
       Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for (UndirectedGraphNode node : nodes){
            map.put(node, new UndirectedGraphNode(node.label));
        }
        return map;
    }

    * */

}
