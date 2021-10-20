public class Main {
    public static class abc{
        int an = 3;
    }
    public static void main(String[] args) {

        WeightedGraph graph= new WeightedGraph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A","B",2);
        graph.addEdge("B","C",2);

        graph.print();
    }
}
