public class App {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Node n1 = graph.addNode(1);
        Node n2 = graph.addNode(2);
        Node n3 = graph.addNode(3);

        graph.addEdge(n1, n2);
        graph.addEdge(n2, n3);

        graph.printGraph();

        System.out.println("\nDFS:");
        graph.getDFS(n1);

        System.out.println("\nBFS:");
        graph.getBFS(n1);

        System.out.println("\nAdjacency Matrix:");
        graph.printAdjacencyMatrix();
    }
}
