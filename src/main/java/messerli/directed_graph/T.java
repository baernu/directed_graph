package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class which represent a specific Node
 */
public class T implements Comparable<T> {
    //Page Rank value for this Node is first set to one.
    private double pageRankValue = 1;
    //ID of the Node as Integer value.
    private int position;
    //List of all outgoing Nodes
    private List<T> nodeListOut;
    //List of all incoming Nodes
    private List<T> nodeListIn;

    public T() {
    }

    public T(int position) {
        this.position = position;
        this.nodeListOut = new ArrayList<>();
        this.nodeListIn = new ArrayList<>();
    }

    public int getInt() {
        return this.position;
    }

    public double getPageRankValue() {
        return this.pageRankValue;
    }
    public void setPageRankValue(double pageRankValue) {
        this.pageRankValue = pageRankValue;
    }

    /**
     * This method compare to values, the Node with the greater Page Rank comes first.
     * @param t: The Node which is compared with this Node
     * @return the comparison values
     */
    public int compareTo(T t) {
        return Double.compare(t.getPageRankValue(), this.getPageRankValue());
    }

    public List<T> getNodeListOut() {
        return this.nodeListOut;
    }

    public List<T> getNodeListIn() {
        return this.nodeListIn;
    }

    /**
     * This method check for a given Edge, if for the starting Node there is already the destination Node in
     * his outgoing Node list.
     * @param e: The Edge who is examined
     * @return true if the Node is already in the outgoing Node list of the starting Vertex. False, if not.
     */
    public boolean checkListNodeOut(Edge e) {
        return e.getVertex().getNodeListOut().stream().anyMatch(element -> element.equals(e.getDestination()));
    }
    /**
     * This method check for a given Edge, if for the destination Node there is already the starting Node in
     * his incoming Node list.
     * @param e: The Edge who is examined
     * @return true if the Node is already in the incoming Node list of the destination Vertex. False, if not.
     */
    public boolean checkListNodeIn( Edge e) {
        return e.getDestination().getNodeListIn().stream().anyMatch(element -> element.equals(e.getVertex()));
    }

    /**
     * This method adds the Node to the List of outgoing Nodes, if the check is false.
     * @param e: The Edge who is examined
     */
    public void addNodeToNodeListOut(Edge e) {
        if (!checkListNodeOut(e)) {
            nodeListOut.add(e.getDestination());
        }

    }
    /**
     * This method adds the Node to the List of incoming Nodes, if the check is false.
     * @param e: The Edge who is examined
     */
    public void addNodeToNodeListIn(Edge e) {
        if (!e.getDestination().checkListNodeIn(e)) {
            nodeListIn.add(e.getVertex());
        }

    }


}
