package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class which represents a directed weighted graph.
 */
public class DirectedGraph extends T {

    //List of all Edges
    private List<Edge> edgeList;
    //List of all Nodes
    private List<T> allNodeList;

    public DirectedGraph() {
        allNodeList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    /**
     * Method checks if a Node exists.
     * @param t: Check for the Node t if this Node exists in the List of all Nodes
     * @return true, if the Node exist, false, if the Node doesn't exist.
     */
    public boolean checkNode(T t) {
        return allNodeList.stream().anyMatch(element -> element.equals(t));
    }


    /**
     * Method adds a Node which doesn't yet exists.
     * @param t: Check for the Node t, if this Node is already in the list of all Nodes.
     *         If the node t is not in this list of all Nodes, then the Node is added to
     *         the list of all Nodes
     */
    public void addNodeToAllList(T t) {
        if (!checkNode(t)) {
            allNodeList.add(t);
        }
    }

    /**
     *  Method adds (if not yet exists) an Edge to the list of all Edges, and adds (if not yet exists)
     *  for the starting Node an outgoing Node,
     *  adds for the destination Node an incoming Node (if not yet exists).
     * @param e: For the Edge e is checked first, if their Nodes are already in the list
     *         of all Nodes. If not, they are added to it. Further this methode check,  if this
     *         Edge is already in the list of all Edges. If not, the Edge e is added to the list
     *         of all Edges. Further the Nodes of the Edges are added to their Nodes.
     *         For the destination Node as ingoing Node,  for the vertex as outgoing Node.
     */
    public void addEdge(Edge e) {
        addNodeToAllList(e.getVertex());
        addNodeToAllList(e.getDestination());

        if (!checkIfEdgeExists(e)) {
            e.getVertex().addNodeToNodeListOut(e);
            e.getDestination().addNodeToNodeListIn(e);
            edgeList.add(e);
        }
    }


    public List<T> getAllNodeList() {
        return this.allNodeList;
    }

    /**
     * Method checks if an Edge already exists.
     * @param e: Check for the Edge e, if this edge is already in the list of all Edges.
     * @return true if the Edge e is already in the list of all Edges, return false if the Edge
     * is not yet in the list of all Edges.
     */
    public boolean checkIfEdgeExists(Edge e) {
        return edgeList.stream().anyMatch(element -> element.equals(e));
    }

    /**
     * This method sort the list of all Nodes in a manner that the Node with the higher Page Rank value
     * become first.
     * @return the sorted list of all Nodes.
     */
    public List<T> rankList() {
        return allNodeList.stream().sorted().collect(Collectors.toList());
    }

    public void printRankList() {
        rankList().stream().forEach(element -> System.out.printf("Vertex: " + element.getInt() +
                "    Page Rank value:   %.5f\n" ,element.getPageRankValue()));
    }

}
