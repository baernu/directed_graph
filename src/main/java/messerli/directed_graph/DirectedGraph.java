package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DirectedGraph extends T {

    private List<T> allNodeList;

    public DirectedGraph() {
        allNodeList = new ArrayList<>();
    }

    public boolean checkNode(T t) {
        return allNodeList.stream().anyMatch(element -> element.equals(t));
    }

    public void addNodeToAllList(T t) {
        if (!checkNode(t)) {
            allNodeList.add(t);
        }

    }

    public void addEdge(T vertex, T destination) {
        addNodeToAllList(vertex);
        addNodeToAllList(destination);

        if (!checkIfEdgeExists(vertex, destination)) {
            vertex.addNode(destination);
            destination.increase();

        }

    }

    public List<T> getAllNodeList() {
        return this.allNodeList;
    }

    public boolean checkIfEdgeExists(T vertex, T destination) {
        return vertex.checkList(destination);
    }

    public List<T> rankList() {
        return allNodeList.stream().sorted().collect(Collectors.toList());
    }

    public void printRankList() {
        rankList().stream().forEach(element -> System.out.println(element.getInt() + " ," + element.getPageRankValue()));
    }

}
