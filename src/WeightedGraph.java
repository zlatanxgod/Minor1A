import java.util.*;

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

    public class NodeEntry{
        Node node;
        int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }


    public int getShortestDistance(String from,String to){

        Node fromNode = nodes.get(from);

        HashMap<Node,Integer> distances = new HashMap<>();
        for(Node n : nodes.values()){
            distances.put(n,Integer.MAX_VALUE);
        }
        distances.replace(fromNode,0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> pqueue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );

        pqueue.add(new NodeEntry(fromNode,0));

        while(!pqueue.isEmpty()){

           Node current=  pqueue.remove().node;
           visited.add(current);

           for(var edge : current.getEdges()){
               if(visited.contains(edge.to)) continue;

               var newDistance = distances.get(current)+ edge.weight;
               if(newDistance < distances.get(edge.to)){
                   distances.replace(edge.to, newDistance);
                   pqueue.add(new NodeEntry(edge.to,newDistance));
               }
           }

        }

        return distances.get(nodes.get(to));
    }


}
