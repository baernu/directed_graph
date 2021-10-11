package messerli.directed_graph;

/**
 * class which represents a specific Edge
 */
public class Edge extends T {
    //starting Node of the Edge
    private T vertex;
    //destination Node of the Edge
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
