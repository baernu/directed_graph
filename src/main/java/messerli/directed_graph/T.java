package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T implements Comparable<T> {
    private Random random = new Random();
    private double pageRankValue = 1; //random.nextDouble()*1000;
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

    public boolean checkListNodeOut(T destination) {
        return nodeListOut.stream().anyMatch(element -> element.equals(destination));
    }

    public boolean checkListNodeIn(T destination) {
        return nodeListIn.stream().anyMatch(element -> element.equals(destination));
    }

    public void addNodeToNodeListOut(T destination) {
        if (!checkListNodeOut(destination)) {
            this.nodeListOut.add(destination);
        }

    }

    public void addNodeToNodeListIn(T destination) {
        if (!checkListNodeIn(destination)) {
            this.nodeListIn.add(destination);
        }

    }


}
