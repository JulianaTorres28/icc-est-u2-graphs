import java.util.*;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public Node addNode(int value) {
        Node node = new Node(value);
        nodes.add(node);
        return node;
    }

    public void addEdge(Node src, Node dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src); 
    }

    public void printGraph() {
        // Ordena nodos por valor
        List<Node> sortedNodes = new ArrayList<>(nodes);
        sortedNodes.sort(Comparator.comparingInt(Node::getValue));

        for (Node node : sortedNodes) {
            System.out.print("Vertex " + node.getValue() + ":");
            // Ordena vecinos
            List<Node> sortedNeighbors = new ArrayList<>(node.getNeighbors());
            sortedNeighbors.sort(Comparator.comparingInt(Node::getValue));
            for (Node neighbor : sortedNeighbors) {
                System.out.print(" -> " + neighbor.getValue());
            }
            System.out.println();
        }
    }

    public void getDFS(Node startNode) {
        Set<Node> visited = new HashSet<>();
        getDFSUtil(startNode, visited);
    }

    private void getDFSUtil(Node node, Set<Node> visited) {
        if (!visited.contains(node)) {
            visited.add(node);
            System.out.println("Visited: " + node.getValue());

            for (Node neighbor : node.getNeighbors()) {
                getDFSUtil(neighbor, visited);
            }
        }
    }

    public void getBFS(Node startNode) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited: " + current.getValue());

            for (Node neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public int[][] getAdjacencyMatrix() {
        int size = nodes.size();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            Node node = nodes.get(i);
            for (Node neighbor : node.getNeighbors()) {
                int j = nodes.indexOf(neighbor);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        System.out.println("Adjacency Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
