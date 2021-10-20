import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightedGraph {
    public class Node{
        String label;
        List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return  label;
        }

        void addEdge(Node to , int weight){
                edges.add(new Edge(this,to,weight));

        }

        public  List<Edge> getEdges(){
            return edges;
        }

    }

    private class Edge{
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return  from+"->"+to ;
        }
    }

    HashMap<String,Node> nodes = new HashMap<>();


    void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label,node);

    }

    void addEdge(String from, String to, int weight){
        Node fromNode = nodes.get(from);
        if(fromNode == null) throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if(toNode == null ) throw new IllegalArgumentException();

        fromNode.addEdge(toNode,weight);
        toNode.addEdge(fromNode,weight);


    }

    void print(){
        for(var node: nodes.values()){
            var targets = node.getEdges();
            if(!targets.isEmpty()){
                System.out.println(node +  " is connected to -> " + targets );
            }


        }
    }


}
