import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightedGraph {
    public class Node{
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return  label;
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
    HashMap<Node, List<Edge>> adjacencyList = new HashMap<>();

    void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
    }

    void addEdge(String from, String to, int weight){
        Node fromNode = nodes.get(from);
        if(fromNode == null) throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if(toNode == null ) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(new Edge(fromNode,toNode,weight));
        adjacencyList.get(toNode).add(new Edge(toNode,fromNode,weight));

    }

    void print(){
        for(var source: adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.println(source +  " is connected to -> " + targets );
            }


        }
    }


}
