/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> visited = new HashMap<>(); // To keep track of neighbours

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // Already cloned node, return
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create cloned node
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Traverse neighbors and add the neighbors for the cloned node
        for (Node n : node.neighbors) {
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;
    }
}