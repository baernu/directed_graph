package messerli.directed_graph;

public class Edge extends T {
    private T nodeIn;
    private T nodeOut;

    public Edge(T vertex, T destination) {
        this.nodeIn = destination;
        this.nodeOut = vertex;
    }

}
