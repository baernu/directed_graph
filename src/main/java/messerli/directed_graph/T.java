package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T implements Comparable<T> {

    private double pageRankValue = 1;
    private int position;
    private List<T> nodeListOut;
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

    public int compareTo(T t) {
        return Double.compare(t.getPageRankValue(), this.getPageRankValue());
    }

    public List<T> getNodeListOut() {
        return this.nodeListOut;
    }

    public List<T> getNodeListIn() {
        return this.nodeListIn;
    }

    public boolean checkListNodeOut(Edge e) {
        return e.getVertex().getNodeListOut().stream().anyMatch(element -> element.equals(e.getDestination()));
    }

    public boolean checkListNodeIn( Edge e) {
        return e.getDestination().getNodeListIn().stream().anyMatch(element -> element.equals(e.getVertex()));
    }

    public void addNodeToNodeListOut(Edge e) {
        if (!checkListNodeOut(e)) {
            nodeListOut.add(e.getDestination());
        }

    }

    public void addNodeToNodeListIn(Edge e) {
        if (!e.getDestination().checkListNodeIn(e)) {
            nodeListIn.add(e.getVertex());
        }

    }


}
