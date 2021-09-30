package messerli.directed_graph;

public class Edge extends T {
    private T vertex;
    private T destination;

    public Edge(T vertex, T destination) {
        this.vertex = vertex;
        this.destination = destination;
    }

    public T getVertex() {
        return this.vertex;
    }

    public T getDestination() {
        return this.destination;
    }

}
